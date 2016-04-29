package com.partypoker.poker.trackers;

import android.app.Application;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.google.common.base.Strings;
import com.partypoker.poker.Config;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationActions;


/**
 * Created by sliubetskyi on 3/25/16.
 */
@TrackingList(value = {IBaseApplicationActions.class})
public class AppDynamicsTrackerAndroid extends AppUsageTrackerAdapter {

    @Override
    public boolean isReadyForUse() {
        if (Strings.isNullOrEmpty(Config.appDynamicsKey))
            return false;
        else
            return true;
    }

    @Override
    public void onAttachToApp(Object data) {
        if (data != null && data instanceof Application) {
            Application app = (Application) data;
            Instrumentation.start(Config.appDynamicsKey,
                    app.getApplicationContext(), Config.kAppDynamicCollectorUrl);
        }
    }
}
