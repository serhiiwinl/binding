package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.trackers.BaseTracker;
import org.robovm.apple.foundation.NSDictionary;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class IOSBaseTracker extends BaseTracker {
    protected NSDictionary<?, ?> appLaunchOptions;

    public void startWithApplicationLaunchOptions(NSDictionary<?, ?> launchOptions) {
        this.appLaunchOptions = launchOptions;
    }
    public abstract void attachToAppController(MyViewController appController);
}
