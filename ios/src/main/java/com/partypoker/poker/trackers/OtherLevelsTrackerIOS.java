package com.partypoker.poker.trackers;

import com.partypoker.poker.Config;
import com.partypoker.poker.MyViewController;
import com.partypoker.poker.application.IUIApplicationDelegate;
import com.partypoker.poker.bindings.otherlevels.OLOptions;
import com.partypoker.poker.bindings.otherlevels.OtherLevels;
import com.partypoker.poker.others.tracking.TrackerConstants;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationActions;
import com.partypoker.poker.tracking.ILoginEvents;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIBackgroundFetchResult;
import org.robovm.apple.uikit.UIRemoteNotification;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.block.VoidBlock1;

import static com.partypoker.poker.bindings.otherlevels.OLOptions.developmentOptions;

/**
 * Created by sliubetskyi on 3/22/16.
 */
@TrackingList(value = {ILoginEvents.class, IBaseApplicationActions.class})
public class OtherLevelsTrackerIOS extends AppUsageTrackerAdapter implements IUIApplicationDelegate {

    protected NSDictionary<?, ?> appLaunchOptions = new NSDictionary<>();
    MyViewController appController;
    private String deviceToken;

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        if (Config.otherLevelsAppKey == null || Config.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }
        //TODO:
        if (app != null && app instanceof MyViewController) {
            appController = (MyViewController) app;
        }
        //if dubug
        OLOptions options = developmentOptions();
        //else
        //OLOptions options = defaultOptions();
        options.setHandleApplicationEvents(false);
        options.setAppKey(Config.otherLevelsAppKey);

        //if (this.appLaunchOptions != null) {
        OtherLevels.startSessionWithLaunchOptions(this.appLaunchOptions, options);
        //}

        if (this.deviceToken != null && !this.deviceToken.equals("")) {
            OtherLevels.registerDevice(this.deviceToken);
        }
    }

    @Override
    public void startWithApplicationLaunchOptions(UIApplicationLaunchOptions launchOptions) {
        if (launchOptions != null)
            this.appLaunchOptions = launchOptions.getDictionary();
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
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        receiveRemoteNotification(userInfo.getDictionary());
    }


    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo, @Block VoidBlock1<UIBackgroundFetchResult> completionHandler) {
        receiveRemoteNotification(userInfo.getDictionary());
    }

    private void receiveRemoteNotification(NSDictionary<?, ?> userInfo) {
        if (userInfo != null && userInfo.get("aps") != null) {
            if (userInfo.get("aps") instanceof NSDictionary<?, ?>) {
                NSDictionary<?, ?> apsDic = (NSDictionary<?, ?>) userInfo.get("aps");
                String title = "";
                String message = "";
                if (apsDic.get("alert") != null) {
                    message = String.valueOf(apsDic.get("alert"));
                }
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
