package com.mycompany.myapp;


import com.mycompany.myapp.experimental.DataEvent;
import com.mycompany.myapp.experimental.Event;
import com.mycompany.myapp.experimental.EventType;
import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.others.CommonInit;
import com.mycompany.myapp.others.Platform;
import com.mycompany.myapp.trackers.IOSAppUsageTracker;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;

public class Main extends UIApplicationDelegateAdapter {

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        initAll();
        if (launchOptions !=null) {
            IOSAppUsageTracker.getInstance().startWithApplicationLaunchOptions(launchOptions.getDictionary());
            didReceiveRemoteNotification(application, launchOptions.getRemoteNotification());
        }

        application.registerForRemoteNotifications();
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Alert, null));
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Sound, null));
        application.registerUserNotificationSettings(new UIUserNotificationSettings(UIUserNotificationType.Badge, null));

        return true;
    }

    @Override
    public void didRegisterForRemoteNotifications(UIApplication application, NSData deviceToken) {
        IOSAppUsageTracker.getInstance().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        IOSAppUsageTracker.getInstance().applicationDidReceiveRemoteNotification(userInfo.getDictionary());
    }

    @Override
    public void didFailToRegisterForRemoteNotifications(UIApplication application, NSError error) {
        IOSAppUsageTracker.getInstance().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
    }

    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, Main.class);
        }
    }

    private void initAll() {
        Event ev = new DataEvent<Integer>("sdsdds", new EventType<Integer>(), 121);
        Event ev2 = new DataEvent<String>("sdsdds", new EventType<String>(), "sdsd");
        ev.eventType.getClass();
        ev2.eventType.getClass();

        BrandComponentFactory.getInstance().init(new Platform() {
            @Override
            public String getType() {
                return Platform.IOS;
            }
        });
        new CommonInit();
    }
}
