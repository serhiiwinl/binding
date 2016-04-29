package com.partypoker.poker.trackers.engagement;

import com.partypoker.poker.Config;
import com.partypoker.poker.application.IUIApplicationDelegate;
import com.partypoker.poker.bindings.engagement.AEReachModule;
import com.partypoker.poker.bindings.engagement.EngagementAgent;
import com.partypoker.poker.others.State;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.concrete.EngagementTracker;
import com.partypoker.poker.tracking.IBaseApplicationActions;
import com.partypoker.poker.tracking.IConfigLoaded;
import org.robovm.apple.adsupport.ASIdentifierManager;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.uikit.*;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.block.VoidBlock1;

/**
 * Created by sliubetskyi on 4/21/16.
 */
@TrackingList(value = {IBaseApplicationActions.class, IConfigLoaded.class})
public class EngagementTrackerIOS extends EngagementTracker implements IUIApplicationDelegate {

    private static final String tag = EngagementTrackerIOS.class.getSimpleName();

    @Override
    public void onConfigLoaded(Config config) {
        //if(debug)
        EngagementAgent.setTestLogEnabled(true);
        System.out.println("Device IDFA: " + ASIdentifierManager.getSharedManager().getAdvertisingIdentifier().toUUID());
        //else
        //EngagementAgent.setTestLogEnabled(false);
    }

    @Override
    public void onResume(State activity) {
        if (isInitialized)
            EngagementAgent.shared().startActivity(activity.getActivityName(), null);
    }

    @Override
    public void onPause(State activity) {
        if (isInitialized)
            EngagementAgent.shared().endActivity();
    }

    @Override
    public void startWithApplicationLaunchOptions(UIApplicationLaunchOptions launchOptions) {
        //in ios client engagement init data are local
        EngagementAgent.setTestLogEnabled(true);
        AEReachModule reach = AEReachModule.moduleWithNotificationIcon(UIImage.getImage("Icon-60"));
        //reach.registerNotifier(new AEDefaultNotifier(), "CustomAENotifier");
        NSArray<AEReachModule> nsArray = new NSArray<>(reach);
        String connectionString = getConnectionString(Config.engagementEndpoint,
                Config.engagementSdkKeyIOS, Config.engagementAppIdIOS);
        EngagementAgent.init(connectionString, nsArray);
        isInitialized = true;
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        System.out.println(tag + " deviceToken " + deviceToken);
        EngagementAgent.shared().registerDeviceToken(deviceToken);
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {
        System.out.println(tag + " Failed to get token, error: " + error);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo) {
        System.out.println(tag + " didReceiveRemoteNotification: " + userInfo.getDictionary());
        EngagementAgent.shared().applicationDidReceiveRemoteNotification(userInfo.getDictionary(), null);
    }

    @Override
    public void didReceiveRemoteNotification(UIApplication application, UIRemoteNotification userInfo,
                                             @Block VoidBlock1<UIBackgroundFetchResult> completionHandler) {
        System.out.println(tag + " didReceiveRemoteNotification with completionHandler: " + userInfo.getDictionary());
        EngagementAgent.shared().applicationDidReceiveRemoteNotification(userInfo.getDictionary(), completionHandler);
    }

}
