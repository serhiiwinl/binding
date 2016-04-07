package com.partypoker.poker;

import android.app.Application;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.impl.AppUsageTracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BrandComponentFactory.getInstance().init(new BrandComponentFactoryAndroid());
        AppUsageTracker.getInstance().onAttachToApp(this);
    }

    public AppUsageConfigInterface getAppConfig() {
        return new AppUsageConfigInterface();
    }
}
