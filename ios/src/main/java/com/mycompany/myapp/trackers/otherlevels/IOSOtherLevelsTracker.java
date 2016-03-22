package com.mycompany.myapp.trackers.otherlevels;

import com.mycompany.myapp.MyViewController;
import com.mycompany.myapp.bindings.otherlevels.OLOptions;
import com.mycompany.myapp.config.AppConfig;
import com.mycompany.myapp.trackers.BaseTracker;

import static com.mycompany.myapp.bindings.otherlevels.OLOptions.*;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class IOSOtherLevelsTracker extends IOSBaseTracker {

    private MyViewController appController;

    @Override
    public void attachToAppController(MyViewController appController) {
        this.appController = appController;

        if (AppConfig.otherLevelsAppKey == null || AppConfig.otherLevelsAppKey.equals("")) {
            System.out.println("OtherLevels application key is nil or empty");
            return;
        }

        OLOptions options = developmentOptions();
        options.handleApplicationEvents();
    }
}
