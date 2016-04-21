package com.partypoker.poker.others;

import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTracker;
import com.partypoker.poker.tracking.*;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {
    public static final String otherLevelsAppKey = "c1bb199e0a4cf211be84c37c4e181c66";
    //public static final String otherLevelsAppKey = "80af66e3445682537e9f2709ffca2131";
    public static final String otherLevelsGsmSender = "799919854778";
    public static final String appDynamicsKey = "EUM-AAB-AUA";
    public static final String kAppDynamicCollectorUrl = "https://euem.itsfogo.com";
    public static final String appsflyerDevKey = "Q4R8wDwV2Br3p7mtw9cb2F";
    private static Platform platform = null;
    private static BrandComponentFactory instance;
    private HashMap<Class<? extends Object>, List<? super AppUsageTracker>> trackersMap = new HashMap<>();

    private List<IBaseApplicationEvents> baseAppEvents = new ArrayList<>();
    private List<ILoginEvents> loginEvents = new ArrayList<>();
    private List<ILogoutEvents> logoutEvents = new ArrayList<>();
    private List<INavigationEvents> navigationEvents = new ArrayList<>();
    private List<IPokerGamePlay> pokerGamePlay = new ArrayList<>();
    private List<IUserActions> userActions = new ArrayList<>();

    protected BrandComponentFactory() {
    }

    public static BrandComponentFactory getInstance() {
        if (instance == null)
            synchronized (BrandComponentFactory.class) {
                if (instance == null) {
                    instance = new BrandComponentFactory();
                    instance.init();
                }
            }
        return instance;
    }

    private void init() {
        initTrackersList();
    }

    public static void init(BrandComponentFactory factoryImpl) {
        instance = factoryImpl;
        instance.init();
    }

    public static Platform getPlatform() {
        return platform;
    }

    protected void addConcreteTracker(AppUsageTracker tracker) {
        Annotation an = tracker.getClass().getAnnotation(TrackingList.class);
        Class[] objects = null;
        if(an != null)
            objects = tracker.getClass().getAnnotation(TrackingList.class).value();
        if (objects == null || objects.length == 0) {
            System.out.printf("list is not specified. Tracker will be listener for all events");
            Iterator<Map.Entry<Class<?>, List<? super AppUsageTracker>>> it = trackersMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().add(tracker);
            }
        } else {
            for (int i = 0; i < objects.length; i++) {
                List<? super AppUsageTracker> list = trackersMap.get(objects[i]);
                if (list != null) {
                    list.add(tracker);
                } else {
                    System.out.printf("You need to create list for this interface");
                }
            }
        }
    }

    public List<IBaseApplicationEvents> getBaseAppEvents() {
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

    public List<IPokerGamePlay> getPokerGamePlay() {
        return pokerGamePlay;
    }

    public List<IUserActions> getUserActions() {
        return userActions;
    }

    protected void initTrackersList() {
        trackersMap.put(IBaseApplicationEvents.class, baseAppEvents);
        trackersMap.put(ILoginEvents.class, loginEvents);
        trackersMap.put(ILogoutEvents.class, logoutEvents);
        trackersMap.put(INavigationEvents.class, navigationEvents);
        trackersMap.put(IPokerGamePlay.class, pokerGamePlay);
        trackersMap.put(IUserActions.class, userActions);
        addTrackers();
    }

    protected void addTrackers() {

    }

}
