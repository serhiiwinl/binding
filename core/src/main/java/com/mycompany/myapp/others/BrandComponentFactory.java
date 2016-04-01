package com.mycompany.myapp.others;

import com.mycompany.myapp.trackers.AppUsageTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {
    private static Platform platform = null;
    private static BrandComponentFactory instance;
    private List<AppUsageTracker> trackersList;

    protected BrandComponentFactory () {

    }

    public synchronized static BrandComponentFactory getInstance() {
        if (instance == null)
            instance = new BrandComponentFactory();
        return instance;
    }

    public static void init(Platform platform) {
        BrandComponentFactory.platform = platform;
    }

    public static Platform getPlatform() {
        return platform;
    }

    public List<AppUsageTracker> getAppUsageTrackersList() {
        initTrackersList();
        return trackersList;
    }

    protected void initTrackersList() {
        if (trackersList == null) {
            initTrackersList();
        }
        trackersList = new ArrayList<AppUsageTracker>();
    }

}
