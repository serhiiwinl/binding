package com.partypoker.poker.trackers.concrete;

import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;

/**
 * Created by sliubetskyi on 4/6/16.
 */
public class AppFlyerTracker extends AppUsageTrackerAdapter {
    protected final String tag = "AppsFlyerPokerTracker";
    protected final String PAYLOAD_KEY = "AppsFlyerPayload";
    protected final String PREFERENCES_NAME = "AppsFlyerPrefs";
    protected final String WMID_KEY = "WMID";
    protected String devkey;
    protected boolean isInitialized = false;
    protected static final String CONVERSION_PARAM_NAME_WMID = "af_sub1";

    public AppFlyerTracker() {
        if(isReadyForUse())
            devkey = BrandComponentFactory.appsflyerDevKey;
    }

    @Override
    public boolean isReadyForUse() {
        if(BrandComponentFactory.appsflyerDevKey == null || BrandComponentFactory.appsflyerDevKey.equals(""))
            return false;
        else
            return true;
    }
}
