package com.partypoker.poker.trackers;

import com.partypoker.poker.IUIApplicationDelegate;
import com.partypoker.poker.MyViewController;
import com.partypoker.poker.bindings.otherlevels.OLOptions;
import com.partypoker.poker.bindings.otherlevels.OtherLevels;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.others.tracking.TrackerConstants;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;

import static com.partypoker.poker.bindings.otherlevels.OLOptions.developmentOptions;

/**
 * Created by sliubetskyi on 3/22/16.
 */
@TrackingList(value = {ILoginEvents.class, IBaseApplicationEvents.class})
public class OtherLevelsTrackerIOS extends AppUsageTrackerAdapter implements IUIApplicationDelegate {

    protected NSDictionary<?, ?> appLaunchOptions;
    MyViewController appController;
    private String deviceToken;

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        if (BrandComponentFactory.otherLevelsAppKey == null || BrandComponentFactory.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }
        //TODO:
        if (app != null && app instanceof MyViewController) {
            appController = (MyViewController) app;
        }

        OLOptions options = developmentOptions();
        options.setHandleApplicationEvents(false);
        options.setAppKey(BrandComponentFactory.otherLevelsAppKey);

        if (this.appLaunchOptions != null) {
            OtherLevels.startSessionWithLaunchOptions(this.appLaunchOptions, options);
        }

        if (this.deviceToken != null && !this.deviceToken.equals("")) {
            OtherLevels.registerDevice(this.deviceToken);
        }
    }

    @Override
    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        this.appLaunchOptions = launchOptions;
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        this.deviceToken = deviceToken.description();
        OtherLevels.registerDevice(this.deviceToken);
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {

    }

    @Override
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {
        if (userInfo != null && userInfo.get("aps") != null) {

            if (userInfo.get("aps") instanceof NSDictionary<?, ?>) {
                String title = "title";
                String message = "message";
                NSDictionary<?, ?> apsDic = (NSDictionary<?, ?>) userInfo.get("aps");
                //TODO:
//                if(apsDic.get("alert")!=null) {
//                    message = apsDic.get("alert");
//                }
                if (appController != null)
                    appController.showPushNotification(new com.partypoker.poker.others.tracking.PushNotification(title, message));
            }
        }
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        OtherLevels.registerEvent(com.partypoker.poker.others.tracking.TrackerConstants.LOGIN_SUCCESS_EVENT, "User screen name: " + screenName);
        OtherLevels.setTagValueForTagName(TrackerConstants.LOGIN_SUCCESS_EVENT + "tag", "User screen name: " + screenName, "string");
    }

}
