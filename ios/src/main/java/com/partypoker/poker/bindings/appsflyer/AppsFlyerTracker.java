package com.partypoker.poker.bindings.appsflyer;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sliubetskyi on 4/7/16.
 */
@NativeClass
public class AppsFlyerTracker extends NSObject {

    //+(AppsFlyerTracker*) sharedTracker;
    @Property(selector = "sharedTracker")
    public static native AppsFlyerTracker sharedTracker();

    /*
    * Prints our messages to the log. This property should only be used in DEBUG mode. The default value
    * is NO.
    */
    //@property (nonatomic, setter = setIsDebug:) BOOL isDebug;
    @Property(selector = "isDebug")
    public native boolean isDebug();
    @Property(selector = "setIsDebug:")
    public native void setIsDebug(boolean isDebug);

    /* Use this property to set your app's Apple ID (taken from the app's page on iTunes Connect) */
    //@property (nonatomic, strong, setter=setAppleAppID:) NSString *appleAppID;
    @Property(selector = "appleAppID")
    public native String getAppleAppID();
    @Property(selector = "setAppleAppID:")
    public native void setAppleAppID(String appleAppID);

    /* Use this property to set your AppsFlyer's dev key. */
    //@property (nonatomic, strong, setter=setAppsFlyerDevKey:) NSString *appsFlyerDevKey;
    @Property(selector = "appsFlyerDevKey")
    public native String getAppsFlyerDevKey();
    @Property(selector = "setAppsFlyerDevKey:")
    public native void setAppsFlyerDevKey(String appsFlyerDevKey);

    /*
    * AppsFlyer delegate. See AppsFlyerTrackerDelegate abvoe
    */
    //@property (unsafe_unretained, nonatomic) id<AppsFlyerTrackerDelegate> delegate;
    @Property(selector = "delegate")
    public native AppsFlyerTrackerDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(AppsFlyerTrackerDelegate delegate);

}
