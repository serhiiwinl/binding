package com.partypoker.poker;

import android.app.Application;
import com.microsoft.azure.engagement.EngagementAgentUtils;
import com.partypoker.poker.activities.MainActivity;
import com.partypoker.poker.factories.BrandComponentFactoryAndroid;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.impl.AppUsageTracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class BaseApplication extends Application {

    public MainActivity getCurrentActivity() {
        return currentActivity;
    }

    private MainActivity currentActivity;

    @Override
    public void onCreate() {
        //TODO:
        if (EngagementAgentUtils.isInDedicatedEngagementProcess(this))
            return;
        super.onCreate();
        BrandComponentFactory.getInstance().init(BrandComponentFactoryAndroid.getInstance());
        BrandComponentFactory.getInstance().getAppUsageTracker().onAttachToApp(this);
        //TODO:
        BrandComponentFactory.getInstance().getAppUsageTracker().onConfigLoaded(new Config());
    }

    public AppUsageConfigInterface getAppConfig() {
        return new AppUsageConfigInterface();
    }

    public void setCurrentActivity(MainActivity activity) {
        this.currentActivity = activity;
    }
}
