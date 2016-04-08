package com.partypoker.poker.trackers;

import com.partypoker.poker.BrandComponentFactoryIOS;
import com.partypoker.poker.trackers.concrete.AppFlyerTracker;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.IUserActions;

/**
 * Created by sliubetskyi on 4/6/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class, ILoginEvents.class, IUserActions.class})
public class AppFlyerTrackerIOS extends AppFlyerTracker {

    @Override
    public boolean isReadyForUse() {
        if (!super.isReadyForUse() || BrandComponentFactoryIOS.appleAppID == null || BrandComponentFactoryIOS.appleAppID.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        super.trackApplicationLaunch(appVersion, appCapacity);
    }


}
