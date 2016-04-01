package com.mycompany.myapp.trackers;

import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.appdynamics.IOSAppDynamicsTracker;
import com.mycompany.myapp.trackers.otherlevels.IOSOtherLevelsTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class IOSBrandComponentFactory extends BrandComponentFactory {

    private static volatile IOSBrandComponentFactory instance;
    private List<IOSAppUsageTracker> trackersList;

    protected IOSBrandComponentFactory () {
    }

    public static IOSBrandComponentFactory getInstance() {
        if (instance == null) {
            synchronized (IOSBrandComponentFactory.class) {
                if (instance == null)
                    instance = new IOSBrandComponentFactory();
            }
        }
        return instance;
    }

    public List<IOSAppUsageTracker> getIOSAppUsageTrackersList() {
        if (trackersList == null) {
            trackersList = new ArrayList<IOSAppUsageTracker>();
            trackersList.add(new IOSOtherLevelsTracker());
            getAppUsageTrackersList().add(new IOSAppDynamicsTracker());
            getAppUsageTrackersList().addAll(trackersList);
        }
        return trackersList;
    }
}
