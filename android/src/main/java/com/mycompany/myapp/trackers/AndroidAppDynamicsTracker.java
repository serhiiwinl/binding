package com.mycompany.myapp.trackers;

import android.app.Application;
import com.appdynamics.eumagent.runtime.Instrumentation;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.appdynamics.AppDynamicsTracker;

/**
 * Created by sliubetskyi on 3/25/16.
 */
public class AndroidAppDynamicsTracker extends AppDynamicsTracker {
    @Override
    public void onAttachToApp(Object app) {
        if(app != null && app instanceof Application) {
            onAttachToApp(app);
        }
    }

    public void onAttachToApp(Application app) {
        Instrumentation.start(AppConfig.appDynamicsKey,
                app.getApplicationContext(), AppConfig.kAppDynamicCollectorUrl);
    }
}
