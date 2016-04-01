package com.mycompany.myapp.trackers;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class IOSAppUsageCompositeTracker extends IOSAppUsageTracker {

    @Override
    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        for (Iterator<IOSAppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().startWithApplicationLaunchOptions(launchOptions);
        }
    }

    @Override
    public void applicationDidRegisterForRemoteNotificationsWithDeviceToken(NSData deviceToken) {
        for (Iterator<IOSAppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidRegisterForRemoteNotificationsWithDeviceToken(deviceToken);
        }
    }

    @Override
    public void applicationDidFailToRegisterForRemoteNotificationsWithError(NSError error) {
        for (Iterator<IOSAppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidFailToRegisterForRemoteNotificationsWithError(error);
        }
    }

    @Override
    public void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo) {
        for (Iterator<IOSAppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext();) {
            iterator.next().applicationDidReceiveRemoteNotification(userInfo);
        }
    }

    private List<IOSAppUsageTracker> getTrackersList() {
        return IOSBrandComponentFactory.getInstance().getIOSAppUsageTrackersList();
    }
}
