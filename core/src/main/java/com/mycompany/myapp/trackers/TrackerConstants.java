package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/22/16.
 */

public class TrackerConstants {
    // Events
    public static final String APPLICATION_LAUNCH_EVENT = "application_launch";
    public static final String ACCESS_REGISTRATION_PAGE_EVENT = "registration_page";
    public static final String SUCCESSFUL_REGISTRATION_EVENT = "registration_success";
    public static final String SUCCESSFUL_DEPOSIT_EVENT = "deposit_success";
    public static final String LOGIN_SUCCESS_EVENT = "login_success";
    public static final String LOGIN_FAILED_ERROR = "login_failed";
    public static final String LOGIN_WORKFLOW_EVENT = "login_workflow";
    public static final String ACCESS_FORGOT_PASSWORD_EVENT = "forgot_password";
    public static final String ACCESS_POKER_DEMO_EVENT = "poker_demo";
    public static final String ACCESS_FORCED_UPDATE_PAGE_EVENT = "forced_update_accessed";
    public static final String ACCESS_UPDATE_PAGE_EVENT = "optional_update_accessed";
    public static final String SKIP_OPTIONAL_UPDATE_EVENT = "optional_update_skip";
    public static final String ACCESS_MAIN_MENU_EVENT = "main_menu";
    public static final String ACCESS_CG_LOBBY_EVENT = "cash_game_lobby";
    public static final String ACCESS_FF_LOBBY_EVENT = "ff_lobby";
    public static final String ACCESS_TOURNAMENT_LOBBY_EVENT = "mtt_lobby";
    public static final String ACCESS_SNG_LOBBY_EVENT = "sng_lobby";
    public static final String GAME_MODE_CHANGE_EVENT = "real_play_switch";
    public static final String ACCESS_CASINO_PAGE_EVENT = "casino_lobby";
    public static final String ACCESS_ACCOUNT_PAGE_EVENT = "account_page";
    public static final String ACCESS_SETTINGS_PAGE_EVENT = "settings_page";
    public static final String ACCESS_CASHIER_PAGE_EVENT = "cashier_page";
    public static final String ACCESS_MY_POKER_PAGE_EVENT = "my_poker_page";
    public static final String ACCESS_ACCOUNT_SETTINGS_PAGE_EVENT = "account_settings_page";
    public static final String ACCESS_BONUSES_PAGE_EVENT = "bonuses_page";
    public static final String ACCESS_TRANSACTION_HISTORY_PAGE_EVENT = "transaction_history_page";
    public static final String ACCESS_HELP_PAGE_EVENT = "help_page";
    public static final String LOGOUT_EVENT = "logout_success";
    public static final String TABLE_SELECTION_EVENT = "select_table";
    public static final String TOURNAMENT_SELECTION_EVENT = "select_tournament";
    public static final String BUY_IN_OPTIONS_EVENT = "buy-in_success";
    public static final String MTT_TOURNAMENT_REGISTRATION_EVENT = "mtt_registered";
    public static final String SNG_TOURNAMENT_REGISTRATION_EVENT = "sng_registered";
    public static final String REMATCH_CONFIRM_EVENT = "rematch_confirm";
    public static final String REMATCH_DECLINE_EVENT = "rematch_decline";
    public static final String REPLAY_CONFIRM_EVENT = "replay_confirm";
    public static final String REPLAY_DECLINE_EVENT = "replay_decline";
    public static final String REENTRY_CONFIRM_EVENT = "reentry_confirm";
    public static final String REENTRY_DECLINE_EVENT = "reentry_decline";
    public static final String MTT_TOURNAMENT_UNREGISTRATION_EVENT = "mtt_unregistered";
    public static final String SNG_TOURNAMENT_UNREGISTRATION_EVENT = "sng_unregistered";
    public static final String ACCESS_TOURNAMENT_DETAILS_PAGE_EVENT = "mtt_details_page";
    public static final String ACCESS_SNG_DETAILS_PAGE_EVENT = "sng_details_page";
    public static final String ACCESS_YOUR_TOURNAMENTS_PAGE_EVENT = "my_tournaments_page";
    public static final String USER_AT_TABLE_EVENT = "seated_at_table";
    public static final String MTT_TOURNAMENT_FINISHED_EVENT = "mtt_finished";
    public static final String SNG_TOURNAMENT_FINISHED_EVENT = "sng_finished";
    public static final String PREACTION_FOLD_EVENT = "preaction_fold";
    public static final String PREACTION_CHECK_EVENT = "preaction_check";
    public static final String PREACTION_CALL_EVENT = "preaction_call";
    public static final String OPEN_GAME_SETTINGS_EVENT = "in_game_settings_page";
    public static final String OPEN_IN_GAME_MENU_EVENT = "in_game_menu_page";
    public static final String FAILED_TO_JOIN_TABLE_ERROR = "failed_to_join_table";
    public static final String AUTOPOSTBLINDS_ON_EVENT = "setting_autopostblind_on";
    public static final String AUTOPOSTBLINDS_OFF_EVENT = "setting_autopostblind_off";
    public static final String FOUR_COLOR_DECK_ON_EVENT = "setting_colordeck_on";
    public static final String FOUR_COLOR_DECK_OFF_EVENT = "setting_colordeck_off";
    public static final String PICTURED_DECK_ON_EVENT = "setting_richcarddesign_on";
    public static final String PICTURED_DECK_OFF_EVENT = "setting_richcarddesign_off";
    public static final String SOUND_ON_EVENT = "setting_sound_on";
    public static final String SOUND_OFF_EVENT = "setting_sound_off";
    public static final String VIBRATE_ON_EVENT = "setting_vibrate_on";
    public static final String VIBRATE_OFF_EVENT = "setting_vibrate_off";
    public static final String ACTION_BET_RAISE_EVENT = "action_bet_raise";
    public static final String ACTION_CHECK_CALL_EVENT = "action_check_call";

    // Extras
    public static final String APP_VERSION_EXTRA_KEY = "app_version";
    public static final String APP_CAPACITY_EXTRA_KEY = "app_capacity";
    public static final String USER_ID_EXTRA_KEY = "userid";
    public static final String ACCOUNT_ID_EXTRA_KEY = "accountid";
    public static final String LOGIN_FAILED_REASON_EXTRA_KEY = "login_failed_reason";
    public static final String REAL_MONEY_GAME_MODE_EXTRA_KEY = "real_money_game_mode";
    public static final String TOURNAMENT_ID_EXTRA_KEY = "tournament_id";
    public static final String OPTIONS_VALUE_EXTRA_KEY = "options_value";
    public static final String TOURNAMENT_BUY_IN_EXTRA_KEY = "tournament_buy_in";
    public static final String TOURNAMENT_ENTRY_FEE_EXTRA_KEY = "tournament_entry_fee";
    public static final String TABLE_ID_EXTRA_KEY = "table_id";
    public static final String TABLE_NAME_EXTRA_KEY = "table_name";
    public static final String SMALL_BLIND_EXTRA_KEY = "small_blind";
    public static final String BIG_BLIND_EXTRA_KEY = "big_blind";
    public static final String TOURNAMENT_NAME_EXTRA_KEY = "tournament_name";
    public static final String TOURNAMENT_RANK_EXTRA_KEY = "tournament_rank";
    public static final String CURRENCY_EXTRA_KEY = "currency";
    public static final String BET_AMOUNT_EXTRA_KEY = "bet_amount";
    public static final String FAILED_TO_JOIN_TABLE_EXTRA_KEY = "failed_to_join_table_reason";
    public static final String TABLE_BUY_IN_EXTRA_KEY = "table_buy_in";
    public static final String DEPOSIT_AMOUNT_EXTRA_KEY = "deposit_amount";
    public static final String DEPOSIT_TYPE_EXTRA_KEY = "deposit_type";
    public static final String ERROR_CODE_EXTRA_KEY = "error_code";

    // Extras values
    public static final String UNDEFINED_EXTRA_VALUE = "undefined";
    public static final String PLAY_MONEY_GAME_EXTRA_VALUE = "play money";
    public static final String CHIPS_EXTRA_VALUE = "chips";
    public static final String POSAPI_LOGIN_POINT = "posapi";
    public static final String BACKEND_LOGIN_POINT = "backend";

    public static final String MAIN_MENU_ACTION_POINT = "main_menu_";
    public static final String NATIVE_MENU_ACTION_POINT = "native_menu_";
    public static final String TOP_BAR_ACTION_POINT = "top_bar_";
}

