package com.mycompany.myapp.trackers.appdynamics;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.appdynamic.ADEumInstrumentation;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.AppUsageTracker;
import com.mycompany.myapp.trackers.IOSAppUsageTrackerInterface;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class IOSAppDynamicsTracker extends AppUsageTracker implements IOSAppUsageTrackerInterface {

    @Override
    public void onAttachToApp(Object app) {

    }

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
