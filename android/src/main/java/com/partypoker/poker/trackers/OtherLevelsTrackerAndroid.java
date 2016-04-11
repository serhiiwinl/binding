package com.partypoker.poker.trackers;

import android.app.Application;
import android.util.Log;
import com.google.common.base.Strings;
import com.otherlevels.android.sdk.OlAndroidLibrary;
import com.otherlevels.android.sdk.Options;
import com.otherlevels.android.sdk.internal.log.Logger;
import com.partypoker.poker.BrandComponentFactoryAndroid;
import com.partypoker.poker.others.BrandComponentFactory;
import com.partypoker.poker.trackers.impl.AppUsageTrackerAdapter;
import com.partypoker.poker.tracking.IBaseApplicationEvents;


/**
 * Created by sliubetskyi on 3/24/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class})
public class OtherLevelsTrackerAndroid extends AppUsageTrackerAdapter {

    public static final String TAG = OtherLevelsTrackerAndroid.class.getSimpleName();

    @Override
    public boolean isReadyForUse() {
        if (Strings.isNullOrEmpty(BrandComponentFactory.otherLevelsAppKey))
            return false;
        else
            return true;
    }

    @Override
    public void onAttachToApp(Object app) {
        Application application = (Application) app;
        //OL logger settings
        Logger.errorLogEnabled = true;
        Logger.infoLogEnabled = true;
        Logger.debugLogEnabled = true;
        Logger.warningLogEnabled = true;
        Logger.verboseLogEnabled = true;

        // Configure initialisation options
        Options options = new Options();
        options.appKey = BrandComponentFactory.otherLevelsAppKey; // mandatory
        options.gcmSenderId = BrandComponentFactoryAndroid.otherlevels_gcm_sender; //optional
        options.disableAutoActivityTracking = true;

        // Initialize the library
        OlAndroidLibrary.init(application, options);

        //log other levels tracking id
        if (OlAndroidLibrary.isInitialised()) {
            String olTrackingID = OlAndroidLibrary.getInstance(application.getBaseContext()).getTrackingId();
            Log.d(TAG, "OL Tracking ID: " + olTrackingID);
        } else {
            Log.e(TAG, "OlAndroidLibrary is not initialised!");
        }
    }
}
