package com.mycompany.myapp.trackers;

import com.mycompany.myapp.tracking.events.ILoginEvents;
import com.mycompany.myapp.tracking.events.ILogoutEvents;

/**
 * Created by sliubetskyi on 4/1/16.
 */
@TrackingList(value = {ILoginEvents.class, ILogoutEvents.class})
public class ConcreteTracker5 extends BaseAppUsageTracker {

    // Login success
    // @param screenName
    // @param accountId
    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        System.out.println(getClass().getSimpleName() + " : trackLoginSuccess");
    }

    // Login failed (wrong password, other reasons)
    // @param reason
    @Override
    public void trackLoginFailed(String loginPoint, String reason, String errorCode) {
        System.out.println(getClass().getSimpleName() + " : trackLoginFailed");
    }

    // Login workflow (screen name registration ... etc.)
    // @param workflow number
    @Override
    public void trackLoginWorkflow(int workflowNumber) {
        System.out.println(getClass().getSimpleName() + " : trackLoginWorkflow");
    }

    // Logout action
    @Override
    public void trackLogout() {
        System.out.println(getClass().getSimpleName() + " : trackLogout");
    }
}