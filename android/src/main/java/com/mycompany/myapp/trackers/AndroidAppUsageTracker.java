package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public abstract class AndroidAppUsageTracker extends com.mycompany.myapp.trackers.impl.BaseAppUsageTracker implements AndroidAppUsageTrackerInterface {

    private static volatile AndroidAppUsageTracker instance = null;

    protected AndroidAppUsageTracker() {
    }

    public static AndroidAppUsageTracker getInstance() {
        if (instance == null) {
            synchronized (AndroidAppUsageTracker.class) {
                if (instance == null) {
                    instance = new AndroidAppUsageCompositeTracker();
                }
            }
        }
        return instance;
    }
}
