package com.partypoker.poker.trackers.concrete;

import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;

/**
 * Created by sliubetskyi on 4/22/16.
 */
public class EngagementTracker extends AppUsageTrackerAdapter {
    protected boolean isInitialized;

    protected String getConnectionString(String engagementEndpoint, String engagementAppId, String engagementSdkKey) {
        return String.format("Endpoint=%s;AppId=%s;SdkKey=%s", engagementEndpoint, engagementAppId, engagementSdkKey);
    }
}
