package com.mycompany.myapp.others;

import com.mycompany.myapp.trackers.TrackingList;
import com.mycompany.myapp.trackers.impl.AppUsageTracker;
import com.mycompany.myapp.trackers.concrete.ConcreteTracker3;
import com.mycompany.myapp.trackers.concrete.ConcreteTracker5;
import com.mycompany.myapp.tracking.events.IBaseApplicationEvents;
import com.mycompany.myapp.tracking.events.ILoginEvents;
import com.mycompany.myapp.tracking.events.ILogoutEvents;
import com.mycompany.myapp.tracking.events.INavigationEvents;
import com.mycompany.myapp.tracking.events.IPokerGamePlay;
import com.mycompany.myapp.tracking.events.IUserActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class BrandComponentFactory {
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
        initTrackersList();
    }

    public synchronized static BrandComponentFactory getInstance() {
        if (instance == null)
            instance = new BrandComponentFactory();
        return instance;
    }

    public void init(Platform platform) {
        BrandComponentFactory.platform = platform;
    }

    public static Platform getPlatform() {
        return platform;
    }

//    public List<AppUsageTracker> getAppUsageTrackersList(Class<?> clazz) {
//        return trackersMap.get(clazz);
//    }

    private <T extends AppUsageTracker> void addTracker(T tracker) {
        Class[] objects = tracker.getClass().getAnnotation(TrackingList.class).value();
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

        addTracker(new ConcreteTracker3());
        addTracker(new ConcreteTracker5());
    }

}
