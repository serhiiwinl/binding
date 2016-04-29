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

import java.util.Iterator;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class CompositeUIApplicationDelegate implements IUIApplicationDelegate {

    private final List<IUIApplicationDelegate> listeners;

    public CompositeUIApplicationDelegate(List<IUIApplicationDelegate> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void startWithApplicationLaunchOptions(UIApplicationLaunchOptions launchOptions) {
        for (Iterator<IUIApplicationDelegate> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().startWithApplicationLaunchOptions(launchOptions);
        }
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        for (Iterator<IUIApplicationDelegate> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
        }
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {
        for (Iterator<IUIApplicationDelegate> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
        }
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        for (Iterator<IUIApplicationDelegate> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().didReceiveRemoteNotification(application, userInfo);
        }
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo, @Block VoidBlock1<UIBackgroundFetchResult> completionHandler) {
        for (Iterator<IUIApplicationDelegate> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().didReceiveRemoteNotification(application, userInfo, completionHandler);
        }
    }
}
