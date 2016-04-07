package com.partypoker.poker;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public interface IUIApplicationDelegate {

    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions);

    // Application did register for remote notification
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken);

    // Application did fail to register for remote notification
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error);

    // Application receive remote notification
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo);
}