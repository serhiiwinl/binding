package com.mycompany.myapp;

import com.mycompany.myapp.trackers.AppUsageCompositeTracker;
import com.mycompany.myapp.trackers.AppUsageTracker;
import com.mycompany.myapp.trackers.appdynamics.BaseAppDynamicsTracker;
import com.mycompany.myapp.trackers.otherlevels.BaseOtherLevelsTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class Factory {
    private static Platform platform = null;
    private static Factory instance;

    private Factory () {

    }

    public static Factory getInstance() {
        if (instance == null)
            instance = new Factory();
        return instance;
    }

    public static void init(Platform platform) {
        Factory.platform = platform;
    }

    public static Platform getPlatform() {
        return platform;
    }

    public static AppUsageCompositeTracker getTracker() {
        return null;
    }

    public List<AppUsageTracker> getAppUsageTrackersList() {
        List<AppUsageTracker> trackersList = new ArrayList<AppUsageTracker>();
        trackersList.add(new BaseOtherLevelsTracker());
        trackersList.add(new BaseAppDynamicsTracker());
        return trackersList;
    }


}
