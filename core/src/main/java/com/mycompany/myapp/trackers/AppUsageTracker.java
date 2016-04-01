package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public abstract class AppUsageTracker implements ICommonAppUsageTrackerInterface {

    private static volatile AppUsageCompositeTracker instance = null;

    protected AppUsageTracker() {
    }

    public static synchronized AppUsageTracker getInstance() {
        if (instance == null)
            instance = new AppUsageCompositeTracker();
        return instance;
    }
}
