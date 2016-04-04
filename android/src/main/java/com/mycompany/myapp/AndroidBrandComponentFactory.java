package com.mycompany.myapp;

import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.AndroidAppUsageTracker;
import com.mycompany.myapp.trackers.AndroidOtherLevelsTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class AndroidBrandComponentFactory extends BrandComponentFactory {
    private static volatile AndroidBrandComponentFactory instance;
    private List<AndroidAppUsageTracker> anTrackersList;

    protected AndroidBrandComponentFactory() {
    }

    public static AndroidBrandComponentFactory getInstance() {
        if (instance == null) {
            synchronized (AndroidBrandComponentFactory.class) {
                if (instance == null)
                    instance = new AndroidBrandComponentFactory();
            }
        }
        return instance;
    }

    public List<AndroidAppUsageTracker> getAndroidAppUsageTrackersList() {
        initAnTrackersList();
        return anTrackersList;
    }

    protected void initAnTrackersList() {
//        if (anTrackersList == null) {
//            anTrackersList = new ArrayList<AndroidAppUsageTracker>();
//            anTrackersList.add(new AndroidOtherLevelsTracker());
//            //getAppUsageTrackersList().addAll(anTrackersList);
//        }
    }

    @Override
    protected void initTrackersList() {
        super.initTrackersList();
        //getAppUsageTrackersList().add(new AndroidAppDynamicsTrackerEventDispatcher());
    }
}
