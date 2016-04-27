package com.partypoker.poker.factories;

import com.partypoker.poker.application.IUIApplicationDelegate;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.AppDynamicsTrackerIOS;
import com.partypoker.poker.trackers.AppsFlyerTrackerIOS;
import com.partypoker.poker.trackers.OtherLevelsTrackerIOS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class BrandComponentFactoryIOS extends BrandComponentFactory {

    private static volatile BrandComponentFactoryIOS instance;
    private List<IUIApplicationDelegate> uiApplicationDelegates;
    public static final String appleAppID = "id687740281";

    public static BrandComponentFactoryIOS getInstance() {
        if (instance == null) {
            synchronized (BrandComponentFactoryIOS.class) {
                if (instance == null)
                    instance = new BrandComponentFactoryIOS();
            }
        }
        return instance;
    }

    public List<IUIApplicationDelegate> getUIApplicationDelegateHandlers() {
        if (this.uiApplicationDelegates == null) {
            this.uiApplicationDelegates = new ArrayList<IUIApplicationDelegate>();
            addUiAppDelegatListeners();
        }
        return this.uiApplicationDelegates;
    }

    protected void addUiAppDelegatListeners() {
        this.uiApplicationDelegates.add(new OtherLevelsTrackerIOS());
    }

    @Override
    protected void addTrackers() {
        this.addConcreteTracker(new OtherLevelsTrackerIOS());
        this.addConcreteTracker(new AppDynamicsTrackerIOS());
        this.addConcreteTracker(new AppsFlyerTrackerIOS());
    }
}
