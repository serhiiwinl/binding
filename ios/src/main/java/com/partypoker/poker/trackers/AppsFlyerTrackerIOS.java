package com.partypoker.poker.trackers;

import com.google.common.base.Strings;
import com.partypoker.poker.BrandComponentFactoryIOS;
import com.partypoker.poker.MyViewController;
import com.partypoker.poker.bindings.appsflyer.AppsFlyerTracker;
import com.partypoker.poker.bindings.appsflyer.AppsFlyerTrackerDelegate;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.concrete.AppFlyerTracker;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSUserDefaults;

import java.util.Map;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class, ILoginEvents.class, IUserActions.class})
public class AppsFlyerTrackerIOS extends AppFlyerTracker implements AppsFlyerTrackerDelegate {

    private MyViewController app;

    @Override
    public boolean isReadyForUse() {
        if (!super.isReadyForUse() || Strings.isNullOrEmpty(BrandComponentFactoryIOS.appleAppID)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onAttachToApp(Object app) {
        this.app = (MyViewController) app;
//        if(debug) {
            AppsFlyerTracker.sharedTracker().setIsDebug(true);
//        }
        AppsFlyerTracker.sharedTracker().setAppsFlyerDevKey(BrandComponentFactory.appsflyerDevKey);
        AppsFlyerTracker.sharedTracker().setAppleAppID(BrandComponentFactoryIOS.appleAppID);
        AppsFlyerTracker.sharedTracker().setDelegate(this);
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        super.trackApplicationLaunch(appVersion, appCapacity);
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        super.trackLoginSuccess(screenName, accountId);
    }

    @Override
    public void trackDeposit(String amount, String currency, String type) {
        super.trackDeposit(amount, currency, type);
    }

    @Override
    public void trackRegistrationComplete(String userName) {
        super.trackRegistrationComplete(userName);
    }

    @Override
    public void onConversionDataReceived(NSDictionary<?, ?> installData) {
        System.out.println("onConversionDataRequestFailure with error: " + installData.toString());
        if (getCachedPayload() != null || getCachedPayload().isEmpty()) {
            //TODO:convertor expected
            parseConversionData((Map<String, String>) installData);
        }
    }

    @Override
    public void onConversionDataRequestFailure(NSError error) {
        System.out.println("onConversionDataRequestFailure with error: " + error.toString());
        setCachedPayload("");
    }

    @Override
    public void onAppOpenAttribution(NSDictionary<?, ?> attributionData) {

    }

    @Override
    public void onAppOpenAttributionFailure(NSError error) {

    }

    @Override
    protected AppUsageConfigInterface getAppConfig() {
        return this.app.getAppConfig();
    }

    @Override
    protected void setCachedPayload(String payload) {
        NSUserDefaults.getStandardUserDefaults().put(PAYLOAD_KEY, payload);
    }

    @Override
    protected Map<String, String> getCachedPayload() {
        //TODO:
        return parsePayload(String.valueOf(NSUserDefaults.getStandardUserDefaults().get(PAYLOAD_KEY)));
    }
}
