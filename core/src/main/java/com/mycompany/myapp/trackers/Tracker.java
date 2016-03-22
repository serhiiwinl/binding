package com.mycompany.myapp.trackers;

import java.util.Objects;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public interface Tracker {
    // Start instance of tracker
    public void start();

    // Attach tracker to application
    public void onAttachToApp(Object app);

    // Activity started
    // @param started activity
    public void startActivity(Object activity);

    // Activity finished
    // @param finished activity
    public void endActivity(Object activity);

    // Job started
    // @param Job name
    public void startJob(String jobName);

    // Job finished
    // @param Job name
    public void endJob(String jobName);

    // Show dialog
    // @param owner activity
    // @param showed dialog name
    public void showDialog(Object activity, String dialogName);

    // Show dialog
    // @param owner activity
    // @param hided dialog name
    public void hideDialog(Object activity, String dialogName);

    // Track application launch
    // @param application version
    // @param application capacity
    public void trackApplicationLaunch(String appVersion, String appCapacity);

    // Access registration page
    public void trackAccessRegistrationPage();

    // Successful registration
    // @param user name
    public void trackRegistrationComplete(String userName);

    // Successful deposit
    // @param amount
    // @param currency
    // @param type
    public void trackDeposit(String amount, String currency, String type);

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

    // Access forgot password page
    public void trackAccessForgotPasswordPage();

    // Access to poker demo
    public void trackAccessPokerDemo();

    // Access forced update page
    public void trackAccessForcedUpdatePage();

    // Access update page
    public void trackAccessUpdateURLPage();

    // Skip optional update
    public void trackSkipOptionalUpdate();

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

    // Game mode change
    // @param isReal - real money or play money game
    public void trackGameModeChange(boolean isReal);

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

    // Logout action
    public void trackLogout();

    // Select table from lobby list (CG/FF)
    // @param table id
    // @param table name
    // @param small blind
    // @param big blind
    // @param currency
    public void trackTableSelection(int tableId, String tableName,
                                    String smallBlind, String bigBlind, String currency);

    // Select tournament from lobby list (SNG/MTT)
    // @param tournament id
    // @param tournament name
    // @param tournament buy in
    // @param tournament entry fee
    // @param currency
    public void trackTournamentSelection(int tournamentId,
                                         String tournamentName, String buyIn, String entryFee,
                                         String currency);

    // Buy-in options CG/FF table
    // @param buy in value
    // @param currency
    public void trackBuyInOptions(String buyIn, String currency);

    // Tournament registration
    // @param tournament category
    // @param tournament id
    // @param tournament buy in
    // @param tournament entry fee
    // @param currency
    public void trackTournamentRegistration(Object tournyCategory,
                                            int tournamentId, String buyIn, String entryFee, String currency);

    // Rematch​ confirm
    // @param tournament id
    // @param tournament buy in
    // @param currency
    public void trackRematchConfirm(int tournamentId, String buyIn,
                                    String currency);

    // Rematch​ decline
    public void trackRematchDecline();

    // Replay confirm
    // @param tournament id
    // @param tournament buy in
    // @param currency
    public void trackReplayConfirm(int tournamentId, String buyIn,
                                   String currency);

    // Replay decline
    public void trackReplayDecline();

    // Reentry confirm
    // @param tournament id
    public void trackReentryConfirm(int tournamentId);

    // ​Reentry decline
    public void trackReentryDecline();

    // Tournament unregistration
    // @param tournament category
    // @param tournament id
    public void trackTournamentUnregistration(
            Object tournyCategory, int tournamentId);

    // Access tournament details page
    public void trackAccessTournamentDetailsPage(int tournamentId);

    // Access SNG tournament details page
    public void trackAccessSNGDetailsPage(int tournamentId);

    // Access your tournaments page
    public void trackAccessYourTournamentsPage();

    // User at table
    public void trackUserAtTable();

    // Tournament finished
    // @param tournament category
    // @param tournament name
    // @param tournament rank
    public void trackTournamentFinished(Object tournyCategory,
                                        int tournamentId, int rank);

    // At table: pre-select buttons
    // @param preaction button tag
    public void trackPreSelectionButtonsSelected(Object preactionButtonTag);

    // Open settings from in-game menu (at table)
    public void trackOpenGameSettings();

    // In-game menu (on table)
    public void trackOpenInGameMenu();

    // Failed to join table
    // @param table id
    // @param reason
    public void trackFailedToJoinTable(int tableId, String reason, String errorCode);

    // Settings: set Autopostblinds
    // @param value
    public void trackSetAutopostblinds(boolean value);

    // Settings: set 4-colordeck
    // @param value
    public void trackSetFourColorDeck(boolean value);

    // Settings: set pictured deck
    // @param value
    public void trackPicturedDeck(boolean value);

    // Settings: set sound
    // @param value
    public void trackSetSound(boolean value);

    // Settings: set vibrate
    // @param value
    public void trackSetVibrate(boolean value);

    // Track the amount of money (stake) for every betplacement
    // @param action button tag
    // @param currency
    // @param amount
    public void trackBet(Object buttonTag, String currency, String amount);
}
