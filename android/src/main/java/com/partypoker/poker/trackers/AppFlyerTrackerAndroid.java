package com.partypoker.poker.trackers;

import android.content.SharedPreferences;
import android.util.Log;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.common.base.Strings;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.tracking.TrackerConstants;
import com.partypoker.poker.trackers.concrete.AppFlyerTracker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sliubetskyi on 4/6/16.
 */
public class AppFlyerTrackerAndroid extends AppFlyerTracker {
    private BaseApplication pokerApp;

    @Override
    public void onAttachToApp(Object app) {
        this.pokerApp = (BaseApplication) app;
        AppsFlyerLib.setAppsFlyerKey(this.devkey);
        AppsFlyerLib.registerConversionListener(this.pokerApp, new AppsFlyerConversionListener() {

            @Override
            public void onInstallConversionFailure(String conversionData) {
                Log.d(tag, "onInstallConversionFailure");
                setCachedPayload("");
            }

            @Override
            public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                Log.d(tag, "onInstallConversionDataLoaded");

                if (getCachedPayload().isEmpty()) {

                    String wmid = conversionData.get(CONVERSION_PARAM_NAME_WMID);

                    Map<String, String> payload = new HashMap<String, String>();
                    String payloadStr = "";
                    if (!Strings.isNullOrEmpty(wmid)) {
                        payload.put(WMID_KEY, wmid);
                        payloadStr = WMID_KEY + "=" + wmid;
                    }

                    setCachedPayload(payloadStr);
                    handlePayload(payload);
                }
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> conversionData) {
            }

            @Override
            public void onAttributionFailure(String conversionData) {
            }
        });
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        // Handle payload, if it is present in user defaults
        if (this.getCachedPayload() != null)
            this.handlePayload(this.getCachedPayload());

        AppsFlyerLib.sendTracking(this.pokerApp);

        Map<String, Object> extras = new HashMap<String, Object>();
        extras.put(TrackerConstants.APP_VERSION_EXTRA_KEY, appVersion);

        AppsFlyerLib.trackEvent(this.pokerApp, TrackerConstants.APPLICATION_LAUNCH_EVENT, extras);
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        Map<String, Object> extras = new HashMap<String, Object>();
        extras.put(TrackerConstants.USER_ID_EXTRA_KEY, screenName);
        extras.put(TrackerConstants.ACCOUNT_ID_EXTRA_KEY,
                Strings.isNullOrEmpty(accountId) ? TrackerConstants.UNDEFINED_EXTRA_VALUE : accountId);

        AppsFlyerLib.trackEvent(this.pokerApp, TrackerConstants.LOGIN_SUCCESS_EVENT, extras);
    }

    @Override
    public void trackRegistrationComplete(String userName) {
        Map<String, Object> extras = new HashMap<String, Object>();
        extras.put(TrackerConstants.USER_ID_EXTRA_KEY, userName);

        AppsFlyerLib.trackEvent(this.pokerApp, TrackerConstants.SUCCESSFUL_REGISTRATION_EVENT, extras);
    }

    @Override
    public void trackDeposit(String amount, String currency, String type) {
        AppsFlyerLib.setCurrencyCode(currency);
        AppsFlyerLib.sendTrackingWithEvent(this.pokerApp, TrackerConstants.SUCCESSFUL_DEPOSIT_EVENT, amount);
    }

    private void setCachedPayload(String payload) {
        SharedPreferences.Editor editor = this.pokerApp.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        editor.putString(PAYLOAD_KEY, payload);
        editor.commit();
    }

    private Map<String, String> getCachedPayload() {
        return this.parsePayload(this.pokerApp.getSharedPreferences(PREFERENCES_NAME, 0).getString(PAYLOAD_KEY, null));
    }

    private void handlePayload(Map<String, String> payload) {
        if (payload != null && !payload.isEmpty())
            if (payload.containsKey(WMID_KEY)) {
                String wmid = payload.get(WMID_KEY);

                AppUsageConfigInterface config = this.pokerApp.getAppConfig();

                if (!Strings.isNullOrEmpty(wmid))
                    config.setWmID(wmid);
            }
    }

    private Map<String, String> parsePayload(String payloadInfo) {
        if (!Strings.isNullOrEmpty(payloadInfo)) {
            Map<String, String> values = new HashMap<String, String>();

            String[] parameters = payloadInfo.split(",");
            for (String par : parameters) {
                String[] v = par.split("=");
                values.put(v[0], v[1]);
            }
            return values;
        }
        return new HashMap<String, String>();
    }
}
