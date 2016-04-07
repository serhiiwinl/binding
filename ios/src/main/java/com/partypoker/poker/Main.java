package com.partypoker.poker;


import com.partypoker.poker.others.BrandComponentFactory;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;

public class Main extends UIApplicationDelegateAdapter {

    public static void main(String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, Main.class);
        }
    }

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        initAll();
        if (launchOptions != null) {
            CompositeUIApplicationDelegate.getInstance().startWithApplicationLaunchOptions(launchOptions.getDictionary());
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
        CompositeUIApplicationDelegate.getInstance().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        CompositeUIApplicationDelegate.getInstance().applicationDidReceiveRemoteNotification(userInfo.getDictionary());
    }

    @Override
    public void didFailToRegisterForRemoteNotifications(UIApplication application, NSError error) {
        CompositeUIApplicationDelegate.getInstance().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
    }

    private void initAll() {
        BrandComponentFactory.init(new BrandComponentFactoryIOS());
    }
}
