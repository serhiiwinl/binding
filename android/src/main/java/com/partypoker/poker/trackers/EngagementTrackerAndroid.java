package com.partypoker.poker.trackers;

import com.microsoft.azure.engagement.EngagementAgent;
import com.microsoft.azure.engagement.EngagementConfiguration;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.concrete.EngagementTracker;

/**
 * Created by sliubetskyi on 4/22/16.
 */
public class EngagementTrackerAndroid extends EngagementTracker {

    private BaseApplication app;

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        this.app = (BaseApplication) app;
        EngagementConfiguration engagementConfiguration = new EngagementConfiguration();
        String connectionString = String.format("Endpoint=%s;AppId=%s;SdkKey=%s", BrandComponentFactory.engagementEndpoint,
                BrandComponentFactory.engagementAppId, BrandComponentFactory.engagementSdkKey);
        engagementConfiguration.setConnectionString(connectionString);
        EngagementAgent.getInstance(this.app).init(engagementConfiguration);
    }
}
