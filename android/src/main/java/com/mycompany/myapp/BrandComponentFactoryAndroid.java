package com.mycompany.myapp;

import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.OtherLevelsTrackerAndroid;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class BrandComponentFactoryAndroid extends BrandComponentFactory {
    private static volatile BrandComponentFactoryAndroid instance;
    public static final String otherlevels_gcm_sender = "799919854778";

    protected BrandComponentFactoryAndroid() {
    }

    public static BrandComponentFactoryAndroid getInstance() {
        if (instance == null) {
            synchronized (BrandComponentFactoryAndroid.class) {
                if (instance == null)
                    instance = new BrandComponentFactoryAndroid();
            }
        }
        return instance;
    }

    protected void initAnTrackersList() {
//        if (anTrackersList == null) {
//            anTrackersList = new ArrayList<AndroidAppUsageTracker>();
//            anTrackersList.add(new OtherLevelsTrackerAndroid());
//            //getAppUsageTrackersList().addAll(anTrackersList);
//        }
    }

    @Override
    protected void addTrackers() {
        super.addTrackers();
        addConcreteTracker(new OtherLevelsTrackerAndroid());
    }
}
