package com.mycompany.myapp.tracking.events;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface INavigationEvents {

    // Access registration page
    public void trackAccessRegistrationPage();

    // Access forgot password page
    public void trackAccessForgotPasswordPage();

    // Access to poker demo
    public void trackAccessPokerDemo();

    // Access forced update page
    public void trackAccessForcedUpdatePage();

    // Access update page
    public void trackAccessUpdateURLPage();

    // Access main menu
    public void trackAccessMainMenu();

    // Access cash game lobby
    // @param isReal - real money or play money game
    public void trackAccessCGLobby(boolean isReal);

    // Access fastforward lobby
    // @param isReal - real money or play money game
    public void trackAccessFFLobby(boolean isReal);

    // Access tournament lobby
    // @param isReal - real money or play money game
    public void trackAccessTournamentLobby(boolean isReal);

    // Access sit & go lobby
    // @param isReal - real money or play money game
    public void trackAccessSNGLobby(boolean isReal);

    // Access jp sit & go lobby
    // @param isReal - real money or play money game
    public void trackAccessSNGJPLobby(boolean isReal);

    // Access casino page
    public void trackAccessCasinoPage();

    // Access account page
    public void trackAccessAccountPage();

    // Access settings page
    public void trackAccessSettingsPage();

    // Access cashier page
    // @param action point
    public void trackAccessCashierPage(String actionPoint);

    // Access my poker page
    public void trackAccessMyPokerPage();

    // Access account settings page
    public void trackAccessAccountSettingsPage();

    // Access bonuses page
    public void trackAccessBonusesPage();

    // Access transaction history page
    public void trackAccessTransactionHistoryPage();

    // Access help page
    public void trackAccessHelpPage();
}
