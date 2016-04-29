package com.partypoker.poker.application;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIBackgroundFetchResult;
import org.robovm.apple.uikit.UIRemoteNotification;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.block.VoidBlock1;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public interface IUIApplicationDelegate {

    public void startWithApplicationLaunchOptions(UIApplicationLaunchOptions launchOptions);

    // Application did register for remote notification
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken);

    // Application did fail to register for remote notification
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error);

    // Application receive remote notification
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo);

    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo, @Block VoidBlock1<UIBackgroundFetchResult> completionHandler);
}
