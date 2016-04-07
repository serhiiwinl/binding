package com.partypoker.poker;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class CompositeUIApplicationDelegate implements IUIApplicationDelegate {

    private static volatile CompositeUIApplicationDelegate instance = null;

    protected CompositeUIApplicationDelegate() {
    }

    public static CompositeUIApplicationDelegate getInstance() {
        if (instance == null) {
            synchronized (CompositeUIApplicationDelegate.class) {
                if (instance == null) {
                    instance = new CompositeUIApplicationDelegate();
                }
            }
        }
        return instance;
    }

    @Override
    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        for (Iterator<IUIApplicationDelegate> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().startWithApplicationLaunchOptions(launchOptions);
        }
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        for (Iterator<IUIApplicationDelegate> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
        }
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {
        for (Iterator<IUIApplicationDelegate> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
        }
    }

    @Override
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {
        for (Iterator<IUIApplicationDelegate> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidReceiveRemoteNotification(userInfo);
        }
    }

    private List<IUIApplicationDelegate> getTrackersList() {
        return BrandComponentFactoryIOS.getInstance().getUIApplicationDelegateHandlers();
    }
}
