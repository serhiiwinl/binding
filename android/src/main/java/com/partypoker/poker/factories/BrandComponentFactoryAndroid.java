package com.partypoker.poker.factories;

import com.partypoker.poker.application.CompositeAppCallbacks;
import com.partypoker.poker.application.IAppCallbacks;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.AppDynamicsTrackerAndroid;
import com.partypoker.poker.trackers.AppsFlyerTrackerAndroid;
import com.partypoker.poker.trackers.EngagementTrackerAndroid;
import com.partypoker.poker.trackers.OtherLevelsTrackerAndroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class BrandComponentFactoryAndroid extends BrandComponentFactory {
    private static volatile BrandComponentFactoryAndroid instance;
    private OtherLevelsTrackerAndroid otherLevelsTrackerAndroid;
    private AppDynamicsTrackerAndroid appDynamicsTrackerAndroid;
    private AppsFlyerTrackerAndroid appsFlyerTrackerAndroid;
    private EngagementTrackerAndroid engagementTrackerAndroid;

    private List<IAppCallbacks> appCallbacksList;
    private CompositeAppCallbacks compositeAppCallbacks;

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

    public CompositeAppCallbacks getCompositeAppCallbacks() {
        if (this.compositeAppCallbacks == null) {
            initAppCallbacksListeners();
            this.compositeAppCallbacks = new CompositeAppCallbacks(this.appCallbacksList);
        }
        return this.compositeAppCallbacks;
    }

    private List<IAppCallbacks> getAppCallbacksListeners() {
        if (this.appCallbacksList == null) {
            this.appCallbacksList = new ArrayList<IAppCallbacks>();
            initAppCallbacksListeners();
        }
        return this.appCallbacksList;
    }

    protected void addAppCallbacksListener(IAppCallbacks listener) {
        this.appCallbacksList.add(listener);
    }

    protected void initAppCallbacksListeners() {
//        addAppCallbacksListener(getOtherLevelTracker());
//        addAppCallbacksListener(getAppDynamicsTrackerAndroid());
//        addAppCallbacksListener(getAppsFlyerTrackerAndroid());
//        addAppCallbacksListener(getEngagementTrackerAndroid());
    }

    @Override
    protected void addTrackers() {
        addConcreteTracker(getOtherLevelTracker());
        addConcreteTracker(getAppDynamicsTrackerAndroid());
        addConcreteTracker(getAppsFlyerTrackerAndroid());
        addConcreteTracker(getEngagementTrackerAndroid());
    }

    protected OtherLevelsTrackerAndroid getOtherLevelTracker() {
        if (this.otherLevelsTrackerAndroid == null)
            this.otherLevelsTrackerAndroid = new OtherLevelsTrackerAndroid();
        return this.otherLevelsTrackerAndroid;
    }

    protected AppsFlyerTrackerAndroid getAppsFlyerTrackerAndroid() {
        if (this.appsFlyerTrackerAndroid == null)
            this.appsFlyerTrackerAndroid = new AppsFlyerTrackerAndroid();
        return this.appsFlyerTrackerAndroid;
    }

    protected AppDynamicsTrackerAndroid getAppDynamicsTrackerAndroid() {
        if (this.appDynamicsTrackerAndroid == null)
            this.appDynamicsTrackerAndroid = new AppDynamicsTrackerAndroid();
        return this.appDynamicsTrackerAndroid;
    }

    protected EngagementTrackerAndroid getEngagementTrackerAndroid() {
        if (this.engagementTrackerAndroid == null)
            this.engagementTrackerAndroid = new EngagementTrackerAndroid();
        return this.engagementTrackerAndroid;
    }
}
