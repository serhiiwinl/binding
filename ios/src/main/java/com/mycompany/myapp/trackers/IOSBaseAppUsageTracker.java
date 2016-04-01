package com.mycompany.myapp.trackers;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class IOSBaseAppUsageTracker extends IOSAppUsageTracker {
    @Override
    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {

    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {

    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {

    }

    @Override
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {

    }
}
