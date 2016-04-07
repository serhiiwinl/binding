package com.partypoker.poker.tracking;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface IUserActions {
    // Game mode change
    // @param isReal - real money or play money game
    public void trackGameModeChange(boolean isReal);

    // Successful registration
    // @param user name
    public void trackRegistrationComplete(String userName);

    // Successful deposit
    // @param amount
    // @param currency
    // @param type
    public void trackDeposit(String amount, String currency, String type);

    // Skip optional update
    public void trackSkipOptionalUpdate();
}
