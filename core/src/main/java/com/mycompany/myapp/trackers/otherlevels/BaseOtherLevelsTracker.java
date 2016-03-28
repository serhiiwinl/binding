package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.AppUsageTracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class BaseOtherLevelsTracker extends AppUsageTracker {

    @Override
    public void onAttachToApp(Object app) {
        if (AppConfig.otherLevelsAppKey == null || AppConfig.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is null or empty");
            return;
        }
    }
}
