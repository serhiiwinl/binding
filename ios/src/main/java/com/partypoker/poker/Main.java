package com.partypoker.poker;


import com.partypoker.poker.others.BrandComponentFactory;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.block.VoidBlock1;

public class Main extends UIApplicationDelegateAdapter {

    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, Main.class);
        }
    }

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        System.out.println("didFinishLaunching");
        initAll();
        if (launchOptions != null) {
            CompositeUIApplicationDelegate.getInstance().startWithApplicationLaunchOptions(launchOptions.getDictionary());
            didReceiveRemoteNotification(application, launchOptions.getRemoteNotification());
        }

        if (application.respondsToSelector(Selector.register("registerUserNotificationSettings:"))) {
            UIUserNotificationType types = UIUserNotificationType.with(UIUserNotificationType.Alert,
                    UIUserNotificationType.Badge, UIUserNotificationType.Sound);
            application.registerUserNotificationSettings(new UIUserNotificationSettings(types, null));
        } else {
            UIRemoteNotificationType types = UIRemoteNotificationType.with(UIRemoteNotificationType.Badge,
                    UIRemoteNotificationType.Alert, UIRemoteNotificationType.Sound);
            application.registerForRemoteNotificationTypes(types);
        }

        return true;
    }

    @Override
    public void didRegisterUserNotificationSettings(UIApplication application, UIUserNotificationSettings notificationSettings) {
        System.out.println("didRegisterUserNotificationSettings");
        application.registerForRemoteNotifications();
    }

    @Override
    public void didRegisterForRemoteNotifications(UIApplication application, NSData deviceToken) {
        System.out.println("didRegisterForRemoteNotifications");
        CompositeUIApplicationDelegate.getInstance().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
    }

    @Override
    public void didFailToRegisterForRemoteNotifications(UIApplication application, NSError error) {
        System.out.println("didFailToRegisterForRemoteNotifications");
        CompositeUIApplicationDelegate.getInstance().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        System.out.println("didReceiveRemoteNotification");
        CompositeUIApplicationDelegate.getInstance().applicationDidReceiveRemoteNotification(userInfo.getDictionary());
    }

    private void initAll() {
        BrandComponentFactory.init(new BrandComponentFactoryIOS());
    }
}
