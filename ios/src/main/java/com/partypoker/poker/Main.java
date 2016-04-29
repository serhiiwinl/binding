package com.partypoker.poker;


import com.partypoker.poker.factories.BrandComponentFactoryIOS;
import com.partypoker.poker.others.BrandComponentFactory;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSData;
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
        BrandComponentFactoryIOS.getInstance().getCompositeUIApplicationDelegate().startWithApplicationLaunchOptions(launchOptions);
        BrandComponentFactory.getInstance().getAppUsageTracker().onConfigLoaded(new Config());
        if (launchOptions != null) {
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
        BrandComponentFactoryIOS.getInstance().getCompositeUIApplicationDelegate().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
    }

    @Override
    public void didFailToRegisterForRemoteNotifications(UIApplication application, NSError error) {
        System.out.println("didFailToRegisterForRemoteNotifications");
        BrandComponentFactoryIOS.getInstance().getCompositeUIApplicationDelegate().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        System.out.println("didReceiveRemoteNotification");
        BrandComponentFactoryIOS.getInstance().getCompositeUIApplicationDelegate().didReceiveRemoteNotification(application, userInfo);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo, @Block VoidBlock1<UIBackgroundFetchResult> completionHandler) {
        super.didReceiveRemoteNotification(application, userInfo, completionHandler);
    }

    private void initAll() {
        BrandComponentFactory.init(new BrandComponentFactoryIOS());
    }
}
