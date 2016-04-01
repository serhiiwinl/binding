package com.mycompany.myapp.trackers;


import com.mycompany.myapp.others.*;

import java.util.Iterator;
import java.util.List;

public class AppUsageCompositeTracker extends AppUsageTracker {

    protected List<AppUsageTracker> trackersList = null;

    private List<AppUsageTracker> getTrackersList() {
        return BrandComponentFactory.getInstance().getAppUsageTrackersList();
    }

    private List<AppUsageTracker> getTrackersList(Class<? extends BaseAppUsageTracker>[] list) {
        List<AppUsageTracker> list1 = BrandComponentFactory.getInstance().getAppUsageTrackersList();
        return BrandComponentFactory.getInstance().getAppUsageTrackersList();
    }

    @Override
    public void start(Object data) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().start(data);
        }
    }

    @Override
    public void onAttachToApp(Object app) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().onAttachToApp(app);
        }
    }

    @Override
    public void startActivity(State activity) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().startActivity(activity);
        }
    }

    @Override
    public void endActivity(State activity) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().startActivity(activity);
        }
    }

    @Override
    public void startJob(String jobName) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().startJob(jobName);
        }
    }

    @Override
    public void endJob(String jobName) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().endJob(jobName);
        }
    }

    @Override
    public void showDialog(State activity, String dialogName) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().startActivity(activity);
        }
    }

    @Override
    public void hideDialog(State activity, String dialogName) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().startActivity(activity);
        }
    }

    @Override
    public void trackApplicationLaunch(String appVersion, String appCapacity) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackApplicationLaunch(appVersion, appCapacity);
        }
    }

    @Override
    public void trackAccessRegistrationPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessRegistrationPage();
        }
    }

    @Override
    public void trackRegistrationComplete(String userName) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackRegistrationComplete(userName);
        }
    }

    @Override
    public void trackDeposit(String amount, String currency, String type) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackDeposit(amount, currency, type);
        }
    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackLoginSuccess(screenName, accountId);
        }
    }

    @Override
    public void trackLoginFailed(String loginPoint, String reason, String errorCode) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackLoginFailed(loginPoint, reason, errorCode);
        }
    }

    @Override
    public void trackLoginWorkflow(int workflowNumber) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackLoginWorkflow(workflowNumber);
        }
    }

    @Override
    public void trackAccessForgotPasswordPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessForgotPasswordPage();
        }
    }

    @Override
    public void trackAccessPokerDemo() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessPokerDemo();
        }
    }

    @Override
    public void trackAccessForcedUpdatePage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessForcedUpdatePage();
        }
    }

    @Override
    public void trackAccessUpdateURLPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessUpdateURLPage();
        }
    }

    @Override
    public void trackSkipOptionalUpdate() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackSkipOptionalUpdate();
        }
    }

    @Override
    public void trackAccessMainMenu() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessMainMenu();
        }
    }

    @Override
    public void trackAccessCGLobby(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessCGLobby(isReal);
        }
    }

    @Override
    public void trackAccessFFLobby(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessFFLobby(isReal);
        }
    }

    @Override
    public void trackAccessTournamentLobby(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessTournamentLobby(isReal);
        }
    }

    @Override
    public void trackAccessSNGLobby(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessSNGLobby(isReal);
        }
    }

    @Override
    public void trackAccessSNGJPLobby(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessSNGJPLobby(isReal);
        }
    }

    @Override
    public void trackGameModeChange(boolean isReal) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackGameModeChange(isReal);
        }
    }

    @Override
    public void trackAccessCasinoPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessCasinoPage();
        }
    }

    @Override
    public void trackAccessAccountPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessAccountPage();
        }
    }

    @Override
    public void trackAccessSettingsPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessSettingsPage();
        }
    }

    @Override
    public void trackAccessCashierPage(String actionPoint) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessCashierPage(actionPoint);
        }
    }

    @Override
    public void trackAccessMyPokerPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessMyPokerPage();
        }
    }

    @Override
    public void trackAccessAccountSettingsPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessAccountSettingsPage();
        }
    }

    @Override
    public void trackAccessBonusesPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessBonusesPage();
        }
    }

    @Override
    public void trackAccessTransactionHistoryPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessTransactionHistoryPage();
        }
    }

    @Override
    public void trackAccessHelpPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessHelpPage();
        }
    }

    @Override
    public void trackLogout() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackLogout();
        }
    }

    @Override
    public void trackTableSelection(int tableId, String tableName,
                                    String smallBlind, String bigBlind, String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackTableSelection(tableId, tableName, smallBlind, bigBlind, currency);
        }
    }

    @Override
    public void trackTournamentSelection(int tournamentId,
                                         String tournamentName, String buyIn, String entryFee,
                                         String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackTournamentSelection(tournamentId, tournamentName, buyIn, entryFee, currency);
        }
    }

    @Override
    public void trackBuyInOptions(String buyIn, String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackBuyInOptions(buyIn, currency);
        }
    }

    @Override
    public void trackTournamentRegistration(PokerTournyCategory tournyCategory,
                                            int tournamentId, String buyIn, String entryFee, String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackTournamentRegistration(tournyCategory, tournamentId, buyIn, entryFee, currency);
        }
    }

    @Override
    public void trackRematchConfirm(int tournamentId, String buyIn, String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackRematchConfirm(tournamentId, buyIn, currency);
        }
    }

    @Override
    public void trackRematchDecline() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackRematchDecline();
        }
    }

    @Override
    public void trackReplayConfirm(int tournamentId, String buyIn, String currency) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackReplayConfirm(tournamentId, buyIn, currency);
        }
    }

    @Override
    public void trackReplayDecline() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackReplayDecline();
        }
    }

    @Override
    public void trackReentryConfirm(int tournamentId) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackReentryConfirm(tournamentId);
        }
    }

    @Override
    public void trackReentryDecline() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackReentryDecline();
        }
    }

    @Override
    public void trackTournamentUnregistration(PokerTournyCategory tournyCategory, int tournamentId) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackTournamentUnregistration(tournyCategory, tournamentId);
        }
    }

    @Override
    public void trackAccessTournamentDetailsPage(int tournamentId) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessTournamentDetailsPage(tournamentId);
        }
    }

    @Override
    public void trackAccessSNGDetailsPage(int tournamentId) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessSNGDetailsPage(tournamentId);
        }
    }

    @Override
    public void trackAccessYourTournamentsPage() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackAccessYourTournamentsPage();
        }
    }

    @Override
    public void trackUserAtTable() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackUserAtTable();
        }
    }

    @Override
    public void trackTournamentFinished(PokerTournyCategory tournyCategory, int tournamentId, int rank) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackTournamentFinished(tournyCategory, tournamentId, rank);
        }
    }

    @Override
    public void trackPreSelectionButtonsSelected(InTurnOption preactionButtonTag) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackPreSelectionButtonsSelected(preactionButtonTag);
        }
    }

    @Override
    public void trackOpenGameSettings() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackOpenGameSettings();
        }
    }

    @Override
    public void trackOpenInGameMenu() {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackOpenInGameMenu();
        }
    }

    @Override
    public void trackFailedToJoinTable(int tableId, String reason, String errorCode) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackFailedToJoinTable(tableId, reason, errorCode);
        }
    }

    @Override
    public void trackSetAutopostblinds(boolean value) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackSetAutopostblinds(value);
        }
    }

    @Override
    public void trackSetFourColorDeck(boolean value) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackSetFourColorDeck(value);
        }
    }

    @Override
    public void trackPicturedDeck(boolean value) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackPicturedDeck(value);
        }
    }

    @Override
    public void trackSetSound(boolean value) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackSetSound(value);
        }
    }

    @Override
    public void trackSetVibrate(boolean value) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackSetVibrate(value);
        }
    }

    @Override
    public void trackBet(ActionButton buttonTag, String currency, String amount) {
        for (Iterator<AppUsageTracker> iterator = getTrackersList().iterator(); iterator.hasNext(); ) {
            iterator.next().trackBet(buttonTag, currency, amount);
        }
    }

}