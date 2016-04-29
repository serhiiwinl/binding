package com.partypoker.poker.trackers.impl;

import com.partypoker.poker.Config;
import com.partypoker.poker.others.ActionButton;
import com.partypoker.poker.others.InTurnOption;
import com.partypoker.poker.others.PokerTournyCategory;
import com.partypoker.poker.others.State;

/**
 * Created by sliubetskyi on 3/28/16.
 */
public class AppUsageTrackerAdapter extends AppUsageTracker {

    @Override
    public void onAttachToApp(Object app) {

    }

    @Override
    public void onResume(State activity) {

    }

    @Override
    public void onPause(State activity) {

    }

    @Override
    public void showDialog(State activity, String dialogName) {

    }

    @Override
    public void hideDialog(State activity, String dialogName) {

    }

    @Override
    public void trackAccessRegistrationPage() {

    }

    @Override
    public void trackRegistrationComplete(String userName) {

    }

    @Override
    public void trackDeposit(String amount, String currency, String type) {

    }

    @Override
    public void trackLoginSuccess(String screenName, String accountId) {

    }

    @Override
    public void trackLoginFailed(String loginPoint, String reason, String errorCode) {

    }

    @Override
    public void trackLoginWorkflow(int workflowNumber) {

    }

    @Override
    public void trackAccessForgotPasswordPage() {

    }

    @Override
    public void trackAccessPokerDemo() {

    }

    @Override
    public void trackAccessForcedUpdatePage() {

    }

    @Override
    public void trackAccessUpdateURLPage() {

    }

    @Override
    public void trackSkipOptionalUpdate() {

    }

    @Override
    public void trackAccessMainMenu() {

    }

    @Override
    public void trackAccessCGLobby(boolean isReal) {

    }

    @Override
    public void trackAccessFFLobby(boolean isReal) {

    }

    @Override
    public void trackAccessTournamentLobby(boolean isReal) {

    }

    @Override
    public void trackAccessSNGLobby(boolean isReal) {

    }

    @Override
    public void trackAccessSNGJPLobby(boolean isReal) {

    }

    @Override
    public void trackGameModeChange(boolean isReal) {

    }

    @Override
    public void trackAccessCasinoPage() {

    }

    @Override
    public void trackAccessAccountPage() {

    }

    @Override
    public void trackAccessSettingsPage() {

    }

    @Override
    public void trackAccessCashierPage(String actionPoint) {

    }

    @Override
    public void trackAccessMyPokerPage() {

    }

    @Override
    public void trackAccessAccountSettingsPage() {

    }

    @Override
    public void trackAccessBonusesPage() {

    }

    @Override
    public void trackAccessTransactionHistoryPage() {

    }

    @Override
    public void trackAccessHelpPage() {

    }

    @Override
    public void trackLogout() {

    }

    @Override
    public void trackTableSelection(int tableId, String tableName, String smallBlind, String bigBlind, String currency) {

    }

    @Override
    public void trackTournamentSelection(int tournamentId, String tournamentName, String buyIn, String entryFee, String currency) {

    }

    @Override
    public void trackBuyInOptions(String buyIn, String currency) {

    }

    @Override
    public void trackTournamentRegistration(PokerTournyCategory tournyCategory, int tournamentId, String buyIn, String entryFee, String currency) {

    }

    @Override
    public void trackRematchConfirm(int tournamentId, String buyIn, String currency) {

    }

    @Override
    public void trackRematchDecline() {

    }

    @Override
    public void trackReplayConfirm(int tournamentId, String buyIn, String currency) {

    }

    @Override
    public void trackReplayDecline() {

    }

    @Override
    public void trackReentryConfirm(int tournamentId) {

    }

    @Override
    public void trackReentryDecline() {

    }

    @Override
    public void trackTournamentUnregistration(PokerTournyCategory tournyCategory, int tournamentId) {

    }

    @Override
    public void trackAccessTournamentDetailsPage(int tournamentId) {

    }

    @Override
    public void trackAccessSNGDetailsPage(int tournamentId) {

    }

    @Override
    public void trackAccessYourTournamentsPage() {

    }

    @Override
    public void trackUserAtTable() {

    }

    @Override
    public void trackTournamentFinished(PokerTournyCategory tournyCategory, int tournamentId, int rank) {

    }

    @Override
    public void trackPreSelectionButtonsSelected(InTurnOption preactionButtonTag) {

    }

    @Override
    public void trackOpenGameSettings() {

    }

    @Override
    public void trackOpenInGameMenu() {

    }

    @Override
    public void trackFailedToJoinTable(int tableId, String reason, String errorCode) {

    }

    @Override
    public void trackSetAutopostblinds(boolean value) {

    }

    @Override
    public void trackSetFourColorDeck(boolean value) {

    }

    @Override
    public void trackPicturedDeck(boolean value) {

    }

    @Override
    public void trackSetSound(boolean value) {

    }

    @Override
    public void trackSetVibrate(boolean value) {

    }

    @Override
    public void trackBet(ActionButton buttonTag, String currency, String amount) {

    }

    @Override
    public void onConfigLoaded(Config config) {

    }
}
