package com.mycompany.myapp;

import com.mycompany.myapp.trackers.Tracker;

/**
 * Created by sliubetskyi on 3/22/16.
 */
public class Factory {
    private static Platform platform = null;
    private static Factory instance;

    private Factory () {

    }

    public static Factory getInstance() {
        if (instance == null)
            instance = new Factory();
        return instance;
    }

    public static void init(Platform platform) {
        Factory.platform = platform;
    }

    public static Platform getPlatform() {
        return platform;
    }

    public static Tracker getTracker() {
        return null;
    }


}
