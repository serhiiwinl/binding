package com.mycompany.myapp.trackers.appdynamics;

import com.mycompany.myapp.Factory;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.AppUsageTracker;

import static com.mycompany.myapp.config.AppConfig.*;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class AppDynamicsTracker extends AppUsageTracker {
    @Override
    public void onAttachToApp(Object app) {
        if (appDynamicsKey == null || appDynamicsKey.equals(""))
            return;
        super.onAttachToApp(app);
    }
}
