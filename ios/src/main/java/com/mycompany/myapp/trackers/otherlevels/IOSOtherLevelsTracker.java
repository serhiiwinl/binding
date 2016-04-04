package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.otherlevels.OLOptions;
import com.mycompany.myapp.bindings.otherlevels.OtherLeveles;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.others.tracking.TrackerConstants;
import com.mycompany.myapp.trackers.*;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;

import static com.mycompany.myapp.bindings.otherlevels.OLOptions.developmentOptions;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class IOSOtherLevelsTracker extends IOSBaseAppUsageTracker {

    protected NSDictionary<?, ?> appLaunchOptions;
    MyViewController appController;
    private String deviceToken;

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        if (AppConfig.otherLevelsAppKey == null || AppConfig.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }
        //TODO:
        if (app != null && app instanceof MyViewController) {
            appController = (MyViewController) app;
        }

        OLOptions options = developmentOptions();
        options.setHandleApplicationEvents(false);
        options.setAppKey(AppConfig.otherLevelsAppKey);

        if (this.appLaunchOptions != null) {
            OtherLeveles.startSessionWithLaunchOptions(this.appLaunchOptions, options);
        }

        if (this.deviceToken != null && !this.deviceToken.equals("")) {
            OtherLeveles.registerDevice(this.deviceToken);
        }
    }

    @Override
    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        this.appLaunchOptions = launchOptions;
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        this.deviceToken = deviceToken.description();
    }

//    @Override
//    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {
//
//    }

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
                    appController.showPushNotification(new com.mycompany.myapp.others.tracking.PushNotification(title, message));
            }
        }
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        OtherLeveles.registerEvent(com.mycompany.myapp.others.tracking.TrackerConstants.LOGIN_SUCCESS_EVENT, "User screen name: " + screenName);
        OtherLeveles.setTagValueForTagName(TrackerConstants.LOGIN_SUCCESS_EVENT + "tag", "User screen name: " + screenName, "string");
    }

}
