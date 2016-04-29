package com.partypoker.poker.trackers.concrete;

import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;

/**
 * Created by sliubetskyi on 4/22/16.
 */
public class EngagementTracker extends AppUsageTrackerAdapter {
    protected boolean isInitialized;

    protected String getConnectionString(String engagementEndpoint,  String engagementSdkKey, String engagementAppId) {
        return String.format("Endpoint=%s;SdkKey=%s;AppId=%s", engagementEndpoint, engagementSdkKey, engagementAppId);
    }
}
