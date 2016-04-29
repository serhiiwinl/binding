package com.partypoker.poker.trackers;

import android.util.Log;
import com.google.common.base.Strings;
import com.otherlevels.android.sdk.OlAndroidLibrary;
import com.otherlevels.android.sdk.Options;
import com.otherlevels.android.sdk.internal.log.Logger;
import com.partypoker.poker.BaseApplication;
import com.partypoker.poker.Config;
import com.partypoker.poker.application.IAppCallbacks;
import com.partypoker.poker.factories.BrandComponentFactoryAndroid;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;


/**
 * Created by sliubetskyi on 3/24/16.
 */
public class OtherLevelsTrackerAndroid extends AppUsageTrackerAdapter implements IAppCallbacks {

    public static final String TAG = OtherLevelsTrackerAndroid.class.getSimpleName();

    @Override
    public boolean isReadyForUse() {
        if (Strings.isNullOrEmpty(Config.otherLevelsAppKey))
            return false;
        else
            return true;
    }

    @Override
    public void onCreate(BaseApplication app) {
        //OL logger settings
        Logger.errorLogEnabled = true;
        Logger.infoLogEnabled = true;
        Logger.debugLogEnabled = true;
        Logger.warningLogEnabled = true;
        Logger.verboseLogEnabled = true;

        // Configure initialisation options
        Options options = new Options();
        options.appKey = Config.otherLevelsAppKey; // mandatory
        options.gcmSenderId = BrandComponentFactoryAndroid.otherlevels_gcm_sender;
        options.disableAutoActivityTracking = true;

        // Initialize the library
        OlAndroidLibrary.init(app, options);

        //log other levels tracking id
        if (OlAndroidLibrary.isInitialised()) {
            String olTrackingID = OlAndroidLibrary.getInstance(app.getBaseContext()).getTrackingId();
            Log.d(TAG, "OL Tracking ID: " + olTrackingID);
        } else {
            Log.e(TAG, "OlAndroidLibrary is not initialised!");
        }
    }

}
