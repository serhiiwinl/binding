package com.mycompany.myapp.trackers;

import com.mycompany.myapp.MyViewController;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

import java.util.HashMap;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public interface IOSAppUsageTrackerInterface extends AppUsageTrackerInterface {

    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions);

    // Application did register for remote notification
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken);

    // Application did fail to register for remote notification
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error);

    // Application receive remote notification
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo);
}
