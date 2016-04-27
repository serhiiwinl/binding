package com.partypoker.poker.application;

import android.app.Activity;
import com.partypoker.poker.BaseApplication;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sliubetskyi on 4/25/16.
 */
public class CompositeAppCallbacks implements IAppCallbacks {

    private final List<IAppCallbacks> listeners;

    public CompositeAppCallbacks(List<IAppCallbacks> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void onCreate(BaseApplication app) {
        for (Iterator<IAppCallbacks> iterator = listeners.iterator(); iterator.hasNext();) {
            iterator.next().onCreate(app);
        }
    }
}
