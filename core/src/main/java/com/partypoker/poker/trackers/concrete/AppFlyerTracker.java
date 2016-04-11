package com.partypoker.poker.trackers.concrete;


import com.google.common.base.Strings;
import com.partypoker.poker.others.AppUsageConfigInterface;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class, ILoginEvents.class, IUserActions.class})
public abstract class AppFlyerTracker extends AppUsageTrackerAdapter {
    protected static final String CONVERSION_PARAM_NAME_WMID = "af_sub1";
    protected final String tag = "AppsFlyerPokerTracker";
    protected final String PAYLOAD_KEY = "AppsFlyerPayload";
    protected final String PREFERENCES_NAME = "AppsFlyerPrefs";
    protected final String WMID_KEY = "WMID";
    protected String devkey;
    protected boolean isInitialized = false;

    public AppFlyerTracker() {
        if (isReadyForUse())
            devkey = BrandComponentFactory.appsflyerDevKey;
    }

    @Override
    public boolean isReadyForUse() {
        if (BrandComponentFactory.appsflyerDevKey == null || BrandComponentFactory.appsflyerDevKey.equals(""))
            return false;
        else
            return true;
    }

    protected void handlePayload(Map<String, String> payload) {
        if (payload != null && !payload.isEmpty())
            if (payload.containsKey(WMID_KEY)) {
                String wmid = payload.get(WMID_KEY);

                AppUsageConfigInterface config = getAppConfig();

                if (!Strings.isNullOrEmpty(wmid))
                    config.setWmID(wmid);
            }
    }

    protected Map<String, String> parsePayload(String payloadInfo) {
        if (!Strings.isNullOrEmpty(payloadInfo)) {
            Map<String, String> values = new HashMap<>();

            String[] parameters = payloadInfo.split(",");
            for (String par : parameters) {
                String[] v = par.split("=");
                values.put(v[0], v[1]);
            }
            return values;
        }
        return new HashMap<>();
    }

    protected void parseConversionData(Map<String, String> conversionData) {
        if (getCachedPayload() == null || getCachedPayload().isEmpty()) {

            String wmid = conversionData.get(CONVERSION_PARAM_NAME_WMID);

            Map<String, String> payload = new HashMap<>();
            String payloadStr = "";
            if (!Strings.isNullOrEmpty(wmid)) {
                payload.put(WMID_KEY, wmid);
                payloadStr = WMID_KEY + "=" + wmid;
            }

            setCachedPayload(payloadStr);
            handlePayload(payload);
        }
    }

    protected abstract AppUsageConfigInterface getAppConfig();

    protected abstract Map<String, String> getCachedPayload();

    protected abstract void setCachedPayload(String payload);

}
