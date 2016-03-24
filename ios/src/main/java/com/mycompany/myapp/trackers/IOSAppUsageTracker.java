package com.mycompany.myapp.trackers;

import com.mycompany.myapp.MyViewController;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class IOSAppUsageTracker extends AppUsageTracker {

    @Override
    public final void onAttachToApp(Object app) {
        if (app instanceof MyViewController) {
            attachToAppController((MyViewController) app);
        } else {
            System.out.println("Error app is not a MyViewController");
        }
    }

    public void attachToAppController(MyViewController app) {

    }

    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {

    }

    // Application did register for remote notification
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {

    }

    // Application did fail to register for remote notification
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {

    }

    // Application receive remote notification
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {

    }
}
