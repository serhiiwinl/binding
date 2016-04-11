package com.partypoker.poker.trackers;

import android.app.Application;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.google.common.base.Strings;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;


/**
 * Created by sliubetskyi on 3/25/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class})
public class AppDynamicsTrackerAndroid extends AppUsageTrackerAdapter {

    @Override
    public boolean isReadyForUse() {
        if (Strings.isNullOrEmpty(BrandComponentFactory.appDynamicsKey))
            return false;
        else
            return true;
    }

    @Override
    public void start(Object data) {
        if (data != null && data instanceof Application) {
            Application app = (Application) data;
            Instrumentation.start(BrandComponentFactory.appDynamicsKey,
                    app.getApplicationContext(), BrandComponentFactory.kAppDynamicCollectorUrl);
        }
    }
}
