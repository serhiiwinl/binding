package com.partypoker.poker.trackers.concrete;

import com.partypoker.poker.others.State;
import com.partypoker.poker.trackers.TrackingList;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;
import com.partypoker.poker.tracking.ILoginEvents;
import com.partypoker.poker.tracking.ILogoutEvents;

/**
 * Created by sliubetskyi on 4/1/16.
 */
@TrackingList(value = {ILoginEvents.class, ILogoutEvents.class, IBaseApplicationEvents.class})
public class ConcreteTracker3 extends AppUsageTrackerAdapter {

    @Override
    public void start(Object data) {
        System.out.println(getClass().getSimpleName() + " : start");
    }

    @Override
    public void onAttachToApp(Object app) {
        System.out.println(getClass().getSimpleName() + " : onAttachToApp");
    }

    @Override
    public void startActivity(State activity) {
        System.out.println(getClass().getSimpleName() + " : startActivity");
    }

    @Override
    public void endActivity(State activity) {
        System.out.println(getClass().getSimpleName() + " : endActivity");
    }

    @Override
    public void startJob(String jobName) {
        System.out.println(getClass().getSimpleName() + " : startJob");
    }

    @Override
    public void endJob(String jobName) {
        System.out.println(getClass().getSimpleName() + " : endJob");
    }

    @Override
    public void showDialog(State activity, String dialogName) {
        System.out.println(getClass().getSimpleName() + " : showDialog");
    }

    @Override
    public void hideDialog(State activity, String dialogName) {
        System.out.println(getClass().getSimpleName() + " : hideDialog");
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        System.out.println(getClass().getSimpleName() + " : trackApplicationLaunch");
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        System.out.println(getClass().getSimpleName() + " : trackLoginSuccess");
    }

    @Override
    public void trackLoginFailed(String loginPoint, String reason, String errorCode) {
        System.out.println(getClass().getSimpleName() + " : trackLoginFailed");
    }

    @Override
    public void trackLoginWorkflow(int workflowNumber) {
        System.out.println(getClass().getSimpleName() + " : trackLoginWorkflow");
    }

    @Override
    public void trackLogout() {
        System.out.println(getClass().getSimpleName() + " : trackLogout");
    }

}
