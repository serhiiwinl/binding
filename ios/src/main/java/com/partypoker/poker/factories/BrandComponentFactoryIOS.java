package com.partypoker.poker.factories;

import com.partypoker.poker.application.CompositeUIApplicationDelegate;
import com.partypoker.poker.application.IUIApplicationDelegate;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.AppDynamicsTrackerIOS;
import com.partypoker.poker.trackers.AppsFlyerTrackerIOS;
import com.partypoker.poker.trackers.engagement.EngagementTrackerIOS;
import com.partypoker.poker.trackers.OtherLevelsTrackerIOS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class BrandComponentFactoryIOS extends BrandComponentFactory {

    public static final String appleAppID = "id687740281";
    private static volatile BrandComponentFactoryIOS instance;
    private List<IUIApplicationDelegate> uiApplicationDelegateListeners;
    private CompositeUIApplicationDelegate compositeUIApplicationDelegate;
    private OtherLevelsTrackerIOS otherLevelsTrackerIOS;
    private AppDynamicsTrackerIOS appDynamicsTrackerIOS;
    private AppsFlyerTrackerIOS appsFlyerTrackerIOS;
    private EngagementTrackerIOS engagementTrackerIOS;

    public static BrandComponentFactoryIOS getInstance() {
        if (instance == null) {
            synchronized (BrandComponentFactoryIOS.class) {
                if (instance == null)
                    instance = new BrandComponentFactoryIOS();
            }
        }
        return instance;
    }

    public CompositeUIApplicationDelegate getCompositeUIApplicationDelegate() {
        if (this.compositeUIApplicationDelegate == null) {
            this.compositeUIApplicationDelegate = new CompositeUIApplicationDelegate(getUIApplicationDelegateListeners());
        }
        return this.compositeUIApplicationDelegate;
    }

    private List<IUIApplicationDelegate> getUIApplicationDelegateListeners() {
        if (this.uiApplicationDelegateListeners == null) {
            this.uiApplicationDelegateListeners = new ArrayList<IUIApplicationDelegate>();
            addUiAppDelegateListeners();
        }
        return this.uiApplicationDelegateListeners;
    }

    protected void addUiAppDelegateListeners() {
        //addUIApplicationDelegateListener(getOtherLevelTrackerIOS());
        addUIApplicationDelegateListener(getEngagementTrackerIOS());
    }

    protected void addUIApplicationDelegateListener(IUIApplicationDelegate listener) {
        this.uiApplicationDelegateListeners.add(listener);
    }

    @Override
    protected void addTrackers() {
        //addConcreteTracker(getOtherLevelTrackerIOS());
        addConcreteTracker(getAppDynamicsTrackerIOS());
        addConcreteTracker(getAppsFlyerTrackerIOS());
        addConcreteTracker(getEngagementTrackerIOS());
    }

    protected OtherLevelsTrackerIOS getOtherLevelTrackerIOS() {
        if (this.otherLevelsTrackerIOS == null)
            this.otherLevelsTrackerIOS = new OtherLevelsTrackerIOS();
        return this.otherLevelsTrackerIOS;
    }

    protected AppsFlyerTrackerIOS getAppsFlyerTrackerIOS() {
        if (this.appsFlyerTrackerIOS == null)
            this.appsFlyerTrackerIOS = new AppsFlyerTrackerIOS();
        return this.appsFlyerTrackerIOS;
    }

    protected AppDynamicsTrackerIOS getAppDynamicsTrackerIOS() {
        if (this.appDynamicsTrackerIOS == null)
            this.appDynamicsTrackerIOS = new AppDynamicsTrackerIOS();
        return this.appDynamicsTrackerIOS;
    }

    protected EngagementTrackerIOS getEngagementTrackerIOS() {
        if (this.engagementTrackerIOS == null)
            this.engagementTrackerIOS = new EngagementTrackerIOS();
        return this.engagementTrackerIOS;
    }
}
