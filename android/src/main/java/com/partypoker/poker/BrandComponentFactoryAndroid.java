package com.partypoker.poker;

import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.AppDynamicsTrackerAndroid;
import com.partypoker.poker.trackers.AppsFlyerTrackerAndroid;
import com.partypoker.poker.trackers.OtherLevelsTrackerAndroid;

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

    @Override
    protected void addTrackers() {
        super.addTrackers();
        addConcreteTracker(new OtherLevelsTrackerAndroid());
        addConcreteTracker(new AppsFlyerTrackerAndroid());
        addConcreteTracker(new AppDynamicsTrackerAndroid());
    }
}
