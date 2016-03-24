package com.mycompany.myapp.trackers;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;

import com.bwinparty.mtv.poker.PokerBaseApplication;
import com.bwinparty.mtv.poker.activity.BasePokerActivity;
import com.bwinparty.mtv.util.brands.BrandComponentFactory;
import com.bwinparty.mtv.poker.model.types.PokerTournyCategory;
import com.bwinparty.mtv.poker.table.model.ActionButton;
import com.bwinparty.mtv.poker.table.model.InTurnOption;

public class AppUsageCompositeTracker extends AppUsageTracker {

	private List<AppUsageTracker> trackersList = null;

	@Override
	public void start() {
		this.trackersList = BrandComponentFactory.getInstance()
				.getAppUsageTrackersList();

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.start();
		}
	}

	@Override
	public void onAttachToApp(PokerBaseApplication app) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.onAttachToApp(app);
		}
	}

	@Override
	public void startActivity(BasePokerActivity activity) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.startActivity(activity);
		}
	}

	@Override
	public void endActivity(BasePokerActivity activity) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.endActivity(activity);
		}
	}

	@Override
	public void startJob(String jobName) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.startJob(jobName);
		}
	}

	@Override
	public void endJob(String jobName) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.endJob(jobName);
		}
	}

	@Override
	public void showDialog(Activity activity, String dialogName) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.showDialog(activity, dialogName);
		}
	}

	@Override
	public void hideDialog(Activity activity, String dialogName) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.hideDialog(activity, dialogName);
		}
	}

	@Override
	public void trackApplicationLaunch(String appVersion, String appCapacity) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackApplicationLaunch(appVersion, appCapacity);
		}
	}

	@Override
	public void trackAccessRegistrationPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessRegistrationPage();
		}
	}

	@Override
	public void trackRegistrationComplete(String userName) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackRegistrationComplete(userName);
		}
	}

	@Override
	public void trackDeposit(String amount, String currency, String type) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackDeposit(amount, currency, type);
		}
	}

	@Override
	public void trackLoginSuccess(String screenName, String accountId) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackLoginSuccess(screenName, accountId);
		}
	}

	@Override
	public void trackLoginFailed(String loginPoint, String reason, String errorCode) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackLoginFailed(loginPoint, reason, errorCode);
		}
	}

	@Override
	public void trackLoginWorkflow(int workflowNumber) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackLoginWorkflow(workflowNumber);
		}
	}

	@Override
	public void trackAccessForgotPasswordPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessForgotPasswordPage();
		}
	}

	@Override
	public void trackAccessPokerDemo() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessPokerDemo();
		}
	}

	@Override
	public void trackAccessForcedUpdatePage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessForcedUpdatePage();
		}
	}

	@Override
	public void trackAccessUpdateURLPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessUpdateURLPage();
		}
	}

	@Override
	public void trackSkipOptionalUpdate() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackSkipOptionalUpdate();
		}
	}

	@Override
	public void trackAccessMainMenu() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessMainMenu();
		}
	}

	@Override
	public void trackAccessCGLobby(boolean isReal) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessCGLobby(isReal);
		}
	}

	@Override
	public void trackAccessFFLobby(boolean isReal) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessFFLobby(isReal);
		}
	}

	@Override
	public void trackAccessTournamentLobby(boolean isReal) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessTournamentLobby(isReal);
		}
	}

	@Override
	public void trackAccessSNGLobby(boolean isReal) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessSNGLobby(isReal);
		}
	}

	@Override
	public void trackGameModeChange(boolean isReal) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackGameModeChange(isReal);
		}
	}

	@Override
	public void trackAccessCasinoPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessCasinoPage();
		}
	}

	@Override
	public void trackAccessAccountPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessAccountPage();
		}
	}

	@Override
	public void trackAccessSettingsPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessSettingsPage();
		}
	}

	@Override
	public void trackAccessCashierPage(String actionPoint) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessCashierPage(actionPoint);
		}
	}
	
	@Override
	public void trackAccessMyPokerPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessMyPokerPage();
		}
	}
	
	@Override
	public void trackAccessAccountSettingsPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessAccountSettingsPage();
		}
	}
	
	@Override
	public void trackAccessBonusesPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessBonusesPage();
		}
	}
	
	@Override
	public void trackAccessTransactionHistoryPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessTransactionHistoryPage();
		}
	}

	@Override
	public void trackAccessHelpPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessHelpPage();
		}
	}

	@Override
	public void trackLogout() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackLogout();
		}
	}

	@Override
	public void trackTableSelection(int tableId, String tableName,
			String smallBlind, String bigBlind, String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackTableSelection(tableId, tableName, smallBlind,
					bigBlind, currency);
		}
	}

	@Override
	public void trackTournamentSelection(int tournamentId,
			String tournamentName, String buyIn, String entryFee,
			String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackTournamentSelection(tournamentId, tournamentName,
					buyIn, entryFee, currency);
		}
	}

	@Override
	public void trackBuyInOptions(String buyIn, String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackBuyInOptions(buyIn, currency);
		}
	}

	@Override
	public void trackTournamentRegistration(PokerTournyCategory tournyCategory,
			int tournamentId, String buyIn, String entryFee, String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackTournamentRegistration(tournyCategory, tournamentId,
					buyIn, entryFee, currency);
		}
	}

	@Override
	public void trackRematchConfirm(int tournamentId, String buyIn,
			String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackRematchConfirm(tournamentId, buyIn, currency);
		}
	}

	@Override
	public void trackRematchDecline() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackRematchDecline();
		}
	}

	@Override
	public void trackReplayConfirm(int tournamentId, String buyIn,
			String currency) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackReplayConfirm(tournamentId, buyIn, currency);
		}
	}

	@Override
	public void trackReplayDecline() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackReplayDecline();
		}
	}

	@Override
	public void trackReentryConfirm(int tournamentId) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackReentryConfirm(tournamentId);
		}
	}

	@Override
	public void trackReentryDecline() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackReentryDecline();
		}
	}

	@Override
	public void trackTournamentUnregistration(
			PokerTournyCategory tournyCategory, int tournamentId) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackTournamentUnregistration(tournyCategory, tournamentId);
		}
	}

	@Override
	public void trackAccessTournamentDetailsPage(int tournamentId) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessTournamentDetailsPage(tournamentId);
		}
	}
	
	@Override
	public void trackAccessSNGDetailsPage(int tournamentId) {
		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessSNGDetailsPage(tournamentId);
		}
	}

	@Override
	public void trackAccessYourTournamentsPage() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackAccessYourTournamentsPage();
		}
	}

	@Override
	public void trackUserAtTable() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackUserAtTable();
		}
	}

	@Override
	public void trackTournamentFinished(PokerTournyCategory tournyCategory,
			int tournamentId, int rank) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackTournamentFinished(tournyCategory, tournamentId, rank);
		}
	}

	@Override
	public void trackPreSelectionButtonsSelected(InTurnOption preactionButtonTag) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackPreSelectionButtonsSelected(preactionButtonTag);
		}
	}

	@Override
	public void trackOpenGameSettings() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackOpenGameSettings();
		}
	}

	@Override
	public void trackOpenInGameMenu() {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackOpenInGameMenu();
		}
	}

	@Override
	public void trackFailedToJoinTable(int tableId, String reason, String errorCode) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackFailedToJoinTable(tableId, reason, errorCode);
		}
	}

	@Override
	public void trackSetAutopostblinds(boolean value) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackSetAutopostblinds(value);
		}
	}

	@Override
	public void trackSetFourColorDeck(boolean value) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackSetFourColorDeck(value);
		}
	}

	@Override
	public void trackPicturedDeck(boolean value) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackPicturedDeck(value);
		}
	}

	@Override
	public void trackSetSound(boolean value) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackSetSound(value);
		}
	}

	@Override
	public void trackSetVibrate(boolean value) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackSetVibrate(value);
		}
	}

	@Override
	public void trackBet(ActionButton buttonTag, String currency, String amount) {
		if (this.trackersList == null)
			return;

		for (Iterator<AppUsageTracker> iterator = this.trackersList.iterator(); iterator
				.hasNext();) {
			AppUsageTracker tracker = iterator.next();
			tracker.trackBet(buttonTag, currency, amount);
		}
	}

}