package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public abstract class IOSAppUsageTracker extends BaseAppUsageTracker implements IOSAppUsageTrackerInterface {

    private static volatile IOSAppUsageTracker instance = null;

    protected IOSAppUsageTracker() {
    }

    public static IOSAppUsageTracker getInstance() {
        if (instance == null) {
            synchronized (IOSAppUsageTracker.class) {
                if (instance == null) {
                    instance = new IOSAppUsageCompositeTracker();
                }
            }
        }
        return instance;
    }

}
