package com.partypoker.poker.trackers;

import com.google.common.base.Strings;
import com.partypoker.poker.BrandComponentFactoryIOS;
import com.partypoker.poker.MyViewController;
import com.partypoker.poker.bindings.appsflyer.AppsFlyerTrackerDelegateAdapter;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.concrete.AppsFlyerTracker;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSUserDefaults;

import static com.partypoker.poker.bindings.appsflyer.AppsFlyerTracker.sharedTracker;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class, ILoginEvents.class, IUserActions.class})
public class AppsFlyerTrackerIOS extends AppsFlyerTracker {

    private MyViewController app;

    @Override
    public boolean isReadyForUse() {
        return (super.isReadyForUse() && !Strings.isNullOrEmpty(BrandComponentFactoryIOS.appleAppID));
    }

    @Override
    public void onAttachToApp(Object app) {
        this.app = (MyViewController) app;
        super.onAttachToApp(app);
//        if(debug) {

        sharedTracker().setIsDebug(true);
//        }
        sharedTracker().setAppsFlyerDevKey(BrandComponentFactory.appsflyerDevKey);
        sharedTracker().setAppleAppID(BrandComponentFactoryIOS.appleAppID);
        sharedTracker().setDelegate(new AppsFlyerTrackerDelegateAdapter() {
            @Override
            public void onConversionDataReceived(NSDictionary<?, ?> installData) {
                onDataReceived(installData.asStringMap());
            }

            @Override
            public void onConversionDataRequestFailure(NSError error) {
                onDataRequestFailure(error.toString());
            }
        });
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
    protected AppUsageConfigInterface getAppConfig() {
        return this.app.getAppConfig();
    }

    protected String getCachedWmId() {
        return String.valueOf(NSUserDefaults.getStandardUserDefaults().get(PAYLOAD_KEY));
    }

    @Override
    protected void saveWmIdToCash(String payload) {
        NSUserDefaults.getStandardUserDefaults().put(PAYLOAD_KEY, payload);
    }
}
