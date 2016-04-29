package com.partypoker.poker.trackers.impl;

import com.partypoker.poker.trackers.AppUsageCompositeTracker;
import com.partypoker.poker.trackers.ICommonAppUsageTrackerInterface;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class AppUsageTracker implements ICommonAppUsageTrackerInterface {

    //TODO:
    public boolean isReadyForUse() {
        return false;
    }

    protected AppUsageTracker() {
    }
}
