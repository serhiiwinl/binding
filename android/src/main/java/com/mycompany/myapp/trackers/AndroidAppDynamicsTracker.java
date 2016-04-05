package com.mycompany.myapp.trackers;

import android.app.Application;
import com.appdynamics.eumagent.runtime.Instrumentation;

import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.impl.AppUsageTrackerAdapter;
import com.mycompany.myapp.tracking.IBaseApplicationEvents;



/**
 * Created by sliubetskyi on 3/25/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class})
public class AndroidAppDynamicsTracker extends AppUsageTrackerAdapter {

    @Override
    public void start(Object data) {
        if (BrandComponentFactory.appDynamicsKey == null || BrandComponentFactory.appDynamicsKey.equals(""))
            return;
        if(data != null && data instanceof Application) {
            Application app = (Application) data;
            Instrumentation.start(BrandComponentFactory.appDynamicsKey,
                    app.getApplicationContext(), BrandComponentFactory.kAppDynamicCollectorUrl);
        }
    }
}
