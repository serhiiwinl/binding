package com.mycompany.myapp.trackers.impl;

import com.mycompany.myapp.trackers.AppUsageCompositeTracker;
import com.mycompany.myapp.trackers.ICommonAppUsageTrackerInterface;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class AppUsageTracker implements ICommonAppUsageTrackerInterface {

    private static volatile AppUsageCompositeTracker instance = null;

    protected AppUsageTracker() {
    }

    public static AppUsageTracker getInstance() {
        if (instance == null) {
            synchronized (AppUsageTracker.class) {
                if (instance == null) {
                    instance = new AppUsageCompositeTracker();
                }
            }
        }
        return instance;
    }
}
