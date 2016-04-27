package com.partypoker.poker.trackers.engagement;

import android.content.Intent;
import com.microsoft.azure.engagement.EngagementAgent;
import com.microsoft.azure.engagement.EngagementConfiguration;
import com.microsoft.azure.engagement.reach.EngagementReachAgent;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.concrete.EngagementTracker;
import com.partypoker.poker.trackers.engagement.CustomEngagementNotifier;

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
        engagementConfiguration.setConnectionString(getConnectionString());
        EngagementAgent.getInstance(this.app).init(engagementConfiguration);
        EngagementReachAgent.getInstance(this.app).registerNotifier(new CustomEngagementNotifier(this.app), Intent.CATEGORY_DEFAULT);
    }

    private String getConnectionString() {
        return String.format("Endpoint=%s;AppId=%s;SdkKey=%s", BrandComponentFactory.engagementEndpoint,
                BrandComponentFactory.engagementAppId, BrandComponentFactory.engagementSdkKey);
    }
}
