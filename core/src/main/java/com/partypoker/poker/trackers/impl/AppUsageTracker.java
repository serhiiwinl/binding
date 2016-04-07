package com.partypoker.poker.trackers.impl;

import com.partypoker.poker.trackers.AppUsageCompositeTracker;
import com.partypoker.poker.trackers.ICommonAppUsageTrackerInterface;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class AppUsageTracker implements ICommonAppUsageTrackerInterface {

    private static volatile AppUsageCompositeTracker instance = null;

    public boolean isReadyForUse() {
        return false;
    }

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
