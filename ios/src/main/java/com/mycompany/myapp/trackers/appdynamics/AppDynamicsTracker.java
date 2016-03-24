package com.mycompany.myapp.trackers.appdynamics;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.appdynamic.ADEumInstrumentation;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.IOSAppUsageTracker;
import org.robovm.apple.foundation.NSDictionary;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class AppDynamicsTracker extends IOSAppUsageTracker {

    public static final String kAppDynamicCollectorUrl = "https://euem.itsfogo.com";

    @Override
    public void attachToAppController(MyViewController app) {
        if (AppConfig.appDynamicsKey == null || AppConfig.appDynamicsKey.equals(""))
            return;
        ADEumInstrumentation.initWithKey(AppConfig.appDynamicsKey, kAppDynamicCollectorUrl);
    }
}
