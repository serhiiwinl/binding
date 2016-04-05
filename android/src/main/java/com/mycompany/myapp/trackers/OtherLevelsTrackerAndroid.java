package com.mycompany.myapp.trackers;

import android.app.Application;
import android.graphics.BitmapFactory;
import com.mycompany.myapp.BrandComponentFactoryAndroid;
import com.mycompany.myapp.others.BrandComponentFactory;
import com.mycompany.myapp.trackers.impl.AppUsageTrackerAdapter;
import com.mycompany.myapp.tracking.IBaseApplicationEvents;
import com.otherlevels.android.sdk.OlAndroidLibrary;
import com.otherlevels.android.sdk.Options;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@TrackingList(value = {IBaseApplicationEvents.class})
public class OtherLevelsTrackerAndroid extends AppUsageTrackerAdapter {

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        Options options = new Options();
        options.appKey = BrandComponentFactory.otherLevelsAppKey; // mandatory
        options.gcmSenderId = BrandComponentFactoryAndroid.otherlevels_gcm_sender; //optional
        options.disableAutoActivityTracking = true;

        // Initialize the library
        OlAndroidLibrary.init((Application) app, options);
    }
}
