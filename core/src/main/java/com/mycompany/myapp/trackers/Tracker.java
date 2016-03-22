package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public interface Tracker {
    @interface AppUsageTracker : NSObject

    + (AppUsageTracker *)sharedInstance;

// Start instance of a tracker with an application launch options.
// Most of a trackers are supposed to be started in UIApplicationDelegate method "application:didFinishLaunchingWithOptions:"
// and some of them may use an application launch options, a second parameter of this UIApplicationDelegate method.
// @param Launch options
    - (void)startWithApplicationLaunchOptions:(NSDictionary *)launchOptions;

// Attach tracker to application controller
// @param aplication controller
    - (void)attachToAppController:(AppController *)appController;

// Application did register for remote notification
    - (void)applicationDidRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken;

// Application did fail to register for remote notification
    - (void)applicationDidFailToRegisterForRemoteNotificationsWithError:(NSError *)error;

// Application receive remote notification
    - (void)applicationDidReceiveRemoteNotification:(NSDictionary *)userInfo;

// Activity started
// @param Activity name
    - (void)startActivity:(NSString *)activityName;

// Activity finished
// @param Activity name
    - (void)endActivity:(NSString *)activityName;
}
