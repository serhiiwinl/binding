package com.partypoker.poker.trackers;

import com.partypoker.poker.trackers.concrete.AppFlyerTracker;

/**
 * Created by sliubetskyi on 4/6/16.
 */
public class AppFlyerTrackerIOS extends AppFlyerTracker {
    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        super.trackApplicationLaunch(appVersion, appCapacity);
    }
}
