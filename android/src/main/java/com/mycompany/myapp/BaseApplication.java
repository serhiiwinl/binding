package com.mycompany.myapp;

import android.app.Application;

import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.others.Platform;
import com.mycompany.myapp.trackers.impl.AppUsageTracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BrandComponentFactory.getInstance().init(new Platform() {
            @Override
            public String getType() {
                return Platform.AN;
            }
        });
        AppUsageTracker.getInstance().onAttachToApp(this);
    }
}
