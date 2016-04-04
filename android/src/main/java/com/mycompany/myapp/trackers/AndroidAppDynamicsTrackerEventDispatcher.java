package com.mycompany.myapp.trackers;

import android.app.Application;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.mycompany.myapp.config.AppConfig;

import static com.mycompany.myapp.config.AppConfig.*;

/**
 * Created by sliubetskyi on 3/25/16.
 */
public class AndroidAppDynamicsTrackerEventDispatcher extends com.mycompany.myapp.trackers.impl.BaseAppUsageTracker {

    @Override
    public void start(Object data) {
        if (appDynamicsKey == null || appDynamicsKey.equals(""))
            return;
        if(data != null && data instanceof Application) {
            Application app = (Application) data;
            Instrumentation.start(AppConfig.appDynamicsKey,
                    app.getApplicationContext(), AppConfig.kAppDynamicCollectorUrl);
        }
    }
}
