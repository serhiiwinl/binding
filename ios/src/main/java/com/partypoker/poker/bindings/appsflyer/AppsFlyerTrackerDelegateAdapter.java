package com.partypoker.poker.bindings.appsflyer;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NotImplemented;

/**
 * Created by sliubetskyi on 4/12/16.
 */
public class AppsFlyerTrackerDelegateAdapter extends NSObject implements AppsFlyerTrackerDelegate {

    @Override
    @NotImplemented("onConversionDataReceived:")
    public void onConversionDataReceived(NSDictionary<?, ?> installData) {
    }

    @Override
    @NotImplemented("onConversionDataRequestFailure:")
    public void onConversionDataRequestFailure(NSError error) {
    }

    @Override
    @NotImplemented("onAppOpenAttribution:")
    public void onAppOpenAttribution(NSDictionary<?, ?> attributionData) {
    }

    @Override
    @NotImplemented("onAppOpenAttributionFailure:")
    public void onAppOpenAttributionFailure(NSError error) {
    }
}
