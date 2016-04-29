package com.partypoker.poker.trackers;

import com.partypoker.poker.Config;
import com.partypoker.poker.bindings.appdynamic.ADEumInstrumentation;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationActions;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@TrackingList(value = {IBaseApplicationActions.class})
public class AppDynamicsTrackerIOS extends AppUsageTrackerAdapter {

    @Override
    public void onAttachToApp(Object app) {
        //init
        ADEumInstrumentation.initWithKey(Config.appDynamicsKey, Config.kAppDynamicCollectorUrl);
    }
}
