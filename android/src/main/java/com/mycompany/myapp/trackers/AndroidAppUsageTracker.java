package com.mycompany.myapp.trackers;

import android.app.Application;

/**
 * Created by sliubetskyi on 3/25/16.
 */
public class AndroidAppUsageTracker extends AppUsageTracker {
    @Override
    public final void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        if (app != null && app instanceof Application) {
            onAttachToApp(app);
        }
    }

    public void onAttachToApp(Application app) {

    }
}
