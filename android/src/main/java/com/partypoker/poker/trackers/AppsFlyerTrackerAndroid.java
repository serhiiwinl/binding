package com.partypoker.poker.trackers;

import android.content.SharedPreferences;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.common.base.Strings;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.tracking.TrackerConstants;
import com.partypoker.poker.trackers.concrete.AppsFlyerTracker;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class, ILoginEvents.class, IUserActions.class})
public class AppsFlyerTrackerAndroid extends AppsFlyerTracker {
    private BaseApplication pokerApp;

    @Override
    public void onAttachToApp(Object app) {
        this.pokerApp = (BaseApplication) app;
        super.onAttachToApp(app);

        AppsFlyerLib.getInstance().registerConversionListener(this.pokerApp, new AppsFlyerConversionListener() {

            @Override
            public void onInstallConversionFailure(String error) {
                onDataRequestFailure(error);
            }

            @Override
            public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                onDataReceived(conversionData);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> conversionData) {
            }

            @Override
            public void onAttributionFailure(String conversionData) {
            }
        });

        AppsFlyerLib.getInstance().startTracking(pokerApp, devKey);
    }


    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        Map<String, Object> extras = new HashMap<>();
        extras.put(TrackerConstants.APP_VERSION_EXTRA_KEY, appVersion);
        AppsFlyerLib.getInstance().trackEvent(this.pokerApp, TrackerConstants.APPLICATION_LAUNCH_EVENT, extras);
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        Map<String, Object> extras = new HashMap<>();
        extras.put(TrackerConstants.USER_ID_EXTRA_KEY, screenName);
        extras.put(TrackerConstants.ACCOUNT_ID_EXTRA_KEY,
                Strings.isNullOrEmpty(accountId) ? TrackerConstants.UNDEFINED_EXTRA_VALUE : accountId);

        AppsFlyerLib.getInstance().trackEvent(this.pokerApp, TrackerConstants.LOGIN_SUCCESS_EVENT, extras);
    }

    @Override
    public void trackRegistrationComplete(String userName) {
        Map<String, Object> extras = new HashMap<>();
        extras.put(TrackerConstants.USER_ID_EXTRA_KEY, userName);
        AppsFlyerLib.getInstance().trackEvent(this.pokerApp, TrackerConstants.SUCCESSFUL_REGISTRATION_EVENT, extras);
    }

    @Override
    public void trackDeposit(String amount, String currency, String type) {
        AppsFlyerLib.getInstance().setCurrencyCode(currency);
        Map<String, Object> extras = new HashMap<>();
        extras.put(TrackerConstants.DEPOSIT_AMOUNT_EXTRA_KEY, amount);
        AppsFlyerLib.getInstance().trackEvent(this.pokerApp, TrackerConstants.SUCCESSFUL_DEPOSIT_EVENT, extras);
    }

    @Override
    protected void saveWmIdToCash(String wmId) {
        SharedPreferences.Editor editor = this.pokerApp.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        editor.putString(PAYLOAD_KEY, wmId);
        editor.apply();
    }

    @Override
    protected String getCachedWmId() {
        return this.pokerApp.getSharedPreferences(PREFERENCES_NAME, 0).getString(PAYLOAD_KEY, null);
    }

    @Override
    protected AppUsageConfigInterface getAppConfig() {
        return this.pokerApp.getAppConfig();
    }
}
