package com.partypoker.poker.bindings.appsflyer;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sliubetskyi on 4/8/16.
 */
@NativeClass
//@protocol AppsFlyerTrackerDelegate <NSObject>
/*
 * This delegate should be use if you want to use AppsFlyer conversion data. See AppsFlyer iOS
 * Tracking SDK documentation for more details http://support.appsflyer.com/entries/25458906-iOS-SDK-Integration-Guide-v2-5-3-x-New-API-
 */
public interface AppsFlyerTrackerDelegate extends NSObjectProtocol {
    //@optional
    //- (void) onConversionDataReceived:(NSDictionary*) installData;
    @Method(selector = "onConversionDataReceived:")
    void onConversionDataReceived(NSDictionary<?, ?> installData);

    //- (void) onConversionDataRequestFailure:(NSError *)error;
    @Method(selector = "onConversionDataRequestFailure:")
    void onConversionDataRequestFailure(NSError error);

    //- (void) onAppOpenAttribution:(NSDictionary*) attributionData;
    @Method(selector = "onAppOpenAttribution:")
    void onAppOpenAttribution(NSDictionary<?, ?> attributionData);

    //- (void) onAppOpenAttributionFailure:(NSError *)error;
    @Method(selector = "onAppOpenAttributionFailure:")
    void onAppOpenAttributionFailure(NSError error);
    //@end
}
