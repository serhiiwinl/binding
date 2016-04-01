package com.mycompany.myapp.tracking.events;

import com.mycompany.myapp.others.State;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface IBaseApplicationEvents {
    // Start instance of tracker
    public void start(Object data);

    // Attach tracker to application
    public void onAttachToApp(Object app);

    // Activity started
    // @param started activity
    public void startActivity(State activity);

    // Activity finished
    // @param finished activity
    public void endActivity(State activity);

    // Job started
    // @param Job name
    public void startJob(String jobName);

    // Job finished
    // @param Job name
    public void endJob(String jobName);

    // Show dialog
    // @param owner activity
    // @param showed dialog name
    public void showDialog(State activity, String dialogName);

    // Show dialog
    // @param owner activity
    // @param hided dialog name
    public void hideDialog(State activity, String dialogName);

    // Track application launch
    // @param application version
    // @param application capacity
    public void trackApplicationLaunch(String appVersion, String appCapacity);
}
