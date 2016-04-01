package com.mycompany.myapp.tracking.events;

import com.mycompany.myapp.others.ActionButton;
import com.mycompany.myapp.others.InTurnOption;
import com.mycompany.myapp.others.PokerTournyCategory;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface IPokerGamePlay {
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
    public void trackTournamentRegistration(PokerTournyCategory tournyCategory,
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
            PokerTournyCategory tournyCategory, int tournamentId);

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
    public void trackTournamentFinished(PokerTournyCategory tournyCategory,
                                        int tournamentId, int rank);

    // At table: pre-select buttons
    // @param preaction button tag
    public void trackPreSelectionButtonsSelected(InTurnOption preactionButtonTag);

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
    public void trackBet(ActionButton buttonTag, String currency, String amount);
}
