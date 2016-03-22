package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.trackers.BaseTracker;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class IOSBaseTracker extends BaseTracker {
    protected NSDictionary<?, ?> appLaunchOptions;

    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        this.appLaunchOptions = launchOptions;
    }

    public abstract void attachToAppController(MyViewController appController);

    // Application did register for remote notification
    public abstract void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken);

    // Application did fail to register for remote notification
    public abstract void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error);

    // Application receive remote notification
    public abstract void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo);
}
