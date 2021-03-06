package com.partypoker.poker.tracking;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface ILoginEvents {

    // Login success
    // @param screenName
    // @param accountId

    public void trackLoginSuccess(String screenName, String accountId);

    // Login failed (wrong password, other reasons)
    // @param reason
    public void trackLoginFailed(String loginPoint, String reason, String errorCode);

    // Login workflow (screen name registration ... etc.)
    // @param workflow number
    public void trackLoginWorkflow(int workflowNumber);
}
