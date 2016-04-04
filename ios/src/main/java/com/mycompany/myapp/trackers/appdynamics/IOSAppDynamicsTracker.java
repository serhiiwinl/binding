package com.mycompany.myapp.trackers.appdynamics;

import com.mycompany.myapp.bindings.appdynamic.ADEumInstrumentation;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.impl.BaseAppUsageTracker;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class IOSAppDynamicsTracker extends BaseAppUsageTracker {

    @Override
    public void onAttachToApp(Object app) {
        if (AppConfig.appDynamicsKey == null || AppConfig.appDynamicsKey.equals("")) {
            System.out.println("IOSAppDynamicsTracker application key is null or empty");
        } else {
            ADEumInstrumentation.initWithKey(AppConfig.appDynamicsKey, AppConfig.kAppDynamicCollectorUrl);
        }
    }
}
