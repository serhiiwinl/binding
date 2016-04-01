package com.mycompany.myapp;

import android.app.Application;
import com.mycompany.myapp.trackers.AppUsageTracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AppUsageTracker.getInstance().onAttachToApp(this);
    }
}
