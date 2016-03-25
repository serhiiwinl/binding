package com.mycompany.myapp;


import com.mycompany.myapp.trackers.otherlevels.IOSOtherLevelsTracker;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;

public class Main extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        initAll();
        if (launchOptions !=null) {
            IOSOtherLevelsTracker.getInstance().startWithApplicationLaunchOptions(launchOptions.getDictionary());
            this.didReceiveRemoteNotification(application, launchOptions.getRemoteNotification());
        }

        application.registerForRemoteNotifications();
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Alert, null));
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Sound, null));
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Badge, null));


        return true;
    }

    @Override
    public void didRegisterForRemoteNotifications(UIApplication application, NSData deviceToken) {
        IOSOtherLevelsTracker.getInstance().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        IOSOtherLevelsTracker.getInstance().applicationDidReceiveRemoteNotification(userInfo.getDictionary());
    }

    @Override
    public void didFailToRegisterForRemoteNotifications(UIApplication application, NSError error) {
        IOSOtherLevelsTracker.getInstance().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
    }

    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, Main.class);
        }
    }

    private void initAll() {
        Factory.getInstance().init(new Platform() {
            @Override
            public String getType() {
                return Platform.IOS;
            }
        });
        new CommonInit();
    }
}
