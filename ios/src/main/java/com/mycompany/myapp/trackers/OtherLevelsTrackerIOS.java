package com.mycompany.myapp.trackers;

import com.mycompany.myapp.IUIApplicationDelegate;
import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.otherlevels.OLOptions;
import com.mycompany.myapp.bindings.otherlevels.OtherLeveles;
import com.mycompany.myapp.others.TestAppConfig;
import com.mycompany.myapp.others.tracking.TrackerConstants;

import com.mycompany.myapp.trackers.impl.AppUsageTrackerAdapter;
import com.mycompany.myapp.tracking.IBaseApplicationEvents;
import com.mycompany.myapp.tracking.ILoginEvents;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

import static com.mycompany.myapp.bindings.otherlevels.OLOptions.developmentOptions;

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
        if (TestAppConfig.otherLevelsAppKey == null || TestAppConfig.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }
        //TODO:
        if (app != null && app instanceof MyViewController) {
            appController = (MyViewController) app;
        }

        OLOptions options = developmentOptions();
        options.setHandleApplicationEvents(false);
        options.setAppKey(TestAppConfig.otherLevelsAppKey);

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
