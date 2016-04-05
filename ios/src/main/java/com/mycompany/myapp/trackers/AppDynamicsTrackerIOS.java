package com.mycompany.myapp.trackers;

import com.mycompany.myapp.bindings.appdynamic.ADEumInstrumentation;
import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.impl.AppUsageTrackerAdapter;
import com.mycompany.myapp.tracking.IBaseApplicationEvents;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class})
public class AppDynamicsTrackerIOS extends AppUsageTrackerAdapter {

    @Override
    public void onAttachToApp(Object app) {
        //івів
        ADEumInstrumentation.initWithKey(BrandComponentFactory.appDynamicsKey, BrandComponentFactory.kAppDynamicCollectorUrl);
    }
}
