package com.partypoker.poker.trackers.concrete;


import com.google.common.base.Strings;
import com.partypoker.poker.Config;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationActions;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;

import java.util.Map;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationActions.class, ILoginEvents.class, IUserActions.class})
public abstract class AppsFlyerTracker extends AppUsageTrackerAdapter {
    protected final String tag = "AppsFlyerPokerTracker";
    protected final String PAYLOAD_KEY = "AppsFlyerPayload";
    protected final String PREFERENCES_NAME = "AppsFlyerPrefs";
    protected String devKey;

    public AppsFlyerTracker() {
        if (isReadyForUse())
            devKey = Config.appsflyerDevKey;
    }

    @Override
    public boolean isReadyForUse() {
        if (Config.appsflyerDevKey == null || Config.appsflyerDevKey.equals(""))
            return false;
        else
            return true;
    }

    @Override
    public void onAttachToApp(Object app) {
        //TODO:Maybe need to do it in other place
        handleWmId(getCachedWmId());
    }

    protected void onDataReceived(Map<String, ? extends Object> installData) {
        System.out.println("onDataReceived: " + installData.toString());
        if (Strings.isNullOrEmpty(getCachedWmId())) {
            String status = String.valueOf(installData.get("af_status"));
            if (status.equalsIgnoreCase("Non-organic")) {
                String wmId = String.valueOf(installData.get("af_sub1"));
                if (!Strings.isNullOrEmpty(wmId) && !wmId.equalsIgnoreCase("null")) {
                    saveWmIdToCash(wmId);
                    handleWmId(wmId);
                }
            }
        }
    }

    protected void onDataRequestFailure(String error) {
        System.out.println("onDataRequestFailure: " + error);
    }

    protected void handleWmId(String wmId) {
        if (!Strings.isNullOrEmpty(wmId)) {
            AppUsageConfigInterface config = getAppConfig();
            config.setWmID(wmId);
        }
    }

    protected abstract AppUsageConfigInterface getAppConfig();

    protected abstract String getCachedWmId();

    protected abstract void saveWmIdToCash(String payload);

}
