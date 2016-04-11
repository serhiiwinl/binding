package com.partypoker.poker.bindings.appsflyer;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sliubetskyi on 4/7/16.
 */
@NativeClass
public class AppsFlyerTracker extends NSObject {

    @Method(selector = "sharedTracker:")
    public static native AppsFlyerTracker sharedTracker();

    @Property(selector = "isDebug")
    public native boolean isDebug();

    @Property(selector = "setIsDebug:")
    public native void setIsDebug(boolean isDebug);

    @Property(selector = "appleAppID")
    public native String getAppleAppID();

    @Property(selector = "setAppleAppID:")
    public native void setAppleAppID(String appleAppID);

    @Property(selector = "appsFlyerDevKey")
    public native String getAppsFlyerDevKey();

    @Property(selector = "setAppsFlyerDevKey:")
    public native void setAppsFlyerDevKey(String appsFlyerDevKey);

    @Property(selector = "delegate")
    public native AppsFlyerTrackerDelegate getDelegate();

    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(AppsFlyerTrackerDelegate delegate);


}
