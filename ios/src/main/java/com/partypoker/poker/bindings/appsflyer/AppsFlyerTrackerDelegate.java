package com.partypoker.poker.bindings.appsflyer;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.annotation.Library;

/**
 * Created by sliubetskyi on 4/8/16.
 */
@NativeClass
public interface AppsFlyerTrackerDelegate extends NSObjectProtocol {

    @Method(selector = "onConversionDataReceived:")
    void onConversionDataReceived(NSDictionary<?,?> installData);
    @Method(selector = "onConversionDataRequestFailure:")
    void onConversionDataRequestFailure(NSError error);
    @Method(selector = "onAppOpenAttribution:")
    void onAppOpenAttribution(NSDictionary<?,?> attributionData);
    @Method(selector = "onAppOpenAttributionFailure:")
    void onAppOpenAttributionFailure(NSError error);
}
