package com.mycompany.myapp.others;

import com.mycompany.myapp.trackers.AppUsageTracker;

import java.util.List;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {
    private static BrandComponentFactory instance;

    public static BrandComponentFactory getInstance() {
        if(instance == null)
            instance = new BrandComponentFactory();
        return instance;
    }

    public List<AppUsageTracker> getAppUsageTrackersList() {
        return null;
    }
}
