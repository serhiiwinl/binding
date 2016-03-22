package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.otherlevels.OLOptions;
import com.mycompany.myapp.bindings.otherlevels.OtherLeveles;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.config.TrackerConstants;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;

import static com.mycompany.myapp.bindings.otherlevels.OLOptions.developmentOptions;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class IOSOtherLevelsTracker extends IOSBaseTracker {

    private MyViewController appController;
    private String deviceToken;

    @Override
    public void attachToAppController(MyViewController appController) {
        this.appController = appController;

        if (AppConfig.otherLevelsAppKey == null || AppConfig.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }

        OLOptions options = developmentOptions();
        options.setHandleApplicationEvents(false);
        options.setAppKey(AppConfig.otherLevelsAppKey);

        OtherLeveles.startSessionWithLaunchOptions(this.appLaunchOptions, options);

        if (deviceToken != null && !deviceToken.equals("")) {
            OtherLeveles.registerDevice(deviceToken);
        }
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        this.deviceToken = deviceToken.description();
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {

    }

    @Override
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {
        if(userInfo != null && userInfo.get("aps")!= null) {

            if(userInfo.get("aps") instanceof NSDictionary<?,?>) {
                String title = "title";
                String message = "message";
                NSDictionary<?,?> apsDic = (NSDictionary<?, ?>) userInfo.get("aps");
                //TODO:
//                if(apsDic.get("alert")!=null) {
//                    message = apsDic.get("alert");
//                }
                //appController
            }
        }
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        OtherLeveles.registerEvent(TrackerConstants.LOGIN_SUCCESS_EVENT, "User screen name: " + screenName);
        OtherLeveles.setTagValueForTagName(TrackerConstants.LOGIN_SUCCESS_EVENT + "tag", "User screen name: " + screenName, "string");
    }







}
