package com.partypoker.poker.tracking;

import com.partypoker.poker.others.State;

/**
 * Created by sliubetskyi on 4/1/16.
 */
public interface IBaseApplicationActions {

    // Attach tracker to application
    public void onAttachToApp(Object app);

    // Activity started
    // @param started activity
    public void onResume(State activity);

    // Activity finished
    // @param finished activity
    public void onPause(State activity);

    // Show dialog
    // @param owner activity
    // @param showed dialog name
    public void showDialog(State activity, String dialogName);

    // Show dialog
    // @param owner activity
    // @param hided dialog name
    public void hideDialog(State activity, String dialogName);
}
