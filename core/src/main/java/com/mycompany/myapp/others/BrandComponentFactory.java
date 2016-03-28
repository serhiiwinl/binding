package com.mycompany.myapp.others;

import com.mycompany.myapp.trackers.AppUsageTracker;
import com.mycompany.myapp.trackers.otherlevels.BaseOtherLevelsTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {
    private static BrandComponentFactory instance;

    public static BrandComponentFactory getInstance() {
        if (instance == null)
            instance = new BrandComponentFactory();
        return instance;
    }

    public List<AppUsageTracker> getAppUsageTrackersList() {
//        List<AppUsageTracker> trackersList = new ArrayList<AppUsageTracker>();
//        trackersList.add(new CapptainTracker());
//        trackersList.add(new AppsFlyerPokerTracker());
////		trackersList.add(new BaseAppDynamicsTracker());
//        trackersList.add(new BaseOtherLevelsTracker());
//        return trackersList;
        List<AppUsageTracker> trackersList = new ArrayList<AppUsageTracker>();
        trackersList.add(new BaseOtherLevelsTracker());
        return trackersList;
    }
}
