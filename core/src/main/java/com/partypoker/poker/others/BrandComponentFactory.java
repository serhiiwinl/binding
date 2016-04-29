package com.partypoker.poker.others;

import com.partypoker.poker.trackers.AppUsageCompositeTracker;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTracker;
import com.partypoker.poker.tracking.*;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {

    private static Platform platform = null;
    private static BrandComponentFactory instance;
    private HashMap<Class<? extends Object>, List<? super AppUsageTracker>> trackersMap = new HashMap<>();

    private List<IBaseApplicationActions> baseAppEvents = new ArrayList<>();
    private List<ILoginEvents> loginEvents = new ArrayList<>();
    private List<ILogoutEvents> logoutEvents = new ArrayList<>();
    private List<INavigationEvents> navigationEvents = new ArrayList<>();
    private List<IPokerGamePlay> pokerGamePlay = new ArrayList<>();
    private List<IConfigLoaded> configLoaded = new ArrayList<>();
    private List<IUserActions> userActions = new ArrayList<>();
    private AppUsageTracker appUsageTracker;

    {
        trackersMap.put(IBaseApplicationActions.class, baseAppEvents);
        trackersMap.put(ILoginEvents.class, loginEvents);
        trackersMap.put(ILogoutEvents.class, logoutEvents);
        trackersMap.put(INavigationEvents.class, navigationEvents);
        trackersMap.put(IPokerGamePlay.class, pokerGamePlay);
        trackersMap.put(IUserActions.class, userActions);
        trackersMap.put(IConfigLoaded.class, configLoaded);
    }

    protected BrandComponentFactory() {
    }

    public static BrandComponentFactory getInstance() {
        if (instance == null)
            synchronized (BrandComponentFactory.class) {
                if (instance == null) {
                    instance = new BrandComponentFactory();
                }
            }
        return instance;
    }

    public static void init(BrandComponentFactory factoryImpl) {
        instance = factoryImpl;
    }

    public AppUsageTracker getAppUsageTracker() {
        if (appUsageTracker == null) {
            addTrackers();
            appUsageTracker = new AppUsageCompositeTracker();
        }
        return appUsageTracker;
    }

    protected void addConcreteTracker(AppUsageTracker tracker) {
        Annotation an = tracker.getClass().getAnnotation(TrackingList.class);
        Class[] objects = null;
        if (an != null)
            objects = tracker.getClass().getAnnotation(TrackingList.class).value();
        if (objects == null || objects.length == 0) {
            System.out.printf("list is not specified. Tracker will be listener for all events");
            Iterator<Map.Entry<Class<?>, List<? super AppUsageTracker>>> it = getTrackersMap().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().add(tracker);
            }
        } else {
            for (int i = 0; i < objects.length; i++) {
                List<? super AppUsageTracker> list = getTrackersMap().get(objects[i]);
                if (list != null) {
                    list.add(tracker);
                } else {
                    System.out.printf("You need to create list for this interface");
                }
            }
        }
    }

    public List<IBaseApplicationActions> getBaseAppEvents() {
        return baseAppEvents;
    }

    public List<ILoginEvents> getLoginEvents() {
        return loginEvents;
    }

    public List<ILogoutEvents> getLogoutEvents() {
        return logoutEvents;
    }

    public List<INavigationEvents> getNavigationEvents() {
        return navigationEvents;
    }

    public List<IPokerGamePlay> getPokerGamePlay() { return pokerGamePlay; }

    public List<IConfigLoaded> getConfigLoaded() { return configLoaded; }

    public List<IUserActions> getUserActions() {
        return userActions;
    }

    HashMap<Class<? extends Object>, List<? super AppUsageTracker>> getTrackersMap() {
        return trackersMap;
    }

    protected void addTrackers() {}

}
