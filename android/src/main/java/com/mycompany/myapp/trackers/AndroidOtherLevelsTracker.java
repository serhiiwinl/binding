package com.mycompany.myapp.trackers;

/**
 * Created by sliubetskyi on 3/24/16.
 */
public class AndroidOtherLevelsTracker extends AndroidBaseAppUsageTracker {

    @Override
    public void onAttachToApp(Object app) {
        super.onAttachToApp(app);
        System.out.println("AN OtherLevel test");
    }
}
