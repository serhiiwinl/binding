
package com.mycompany.myapp.bindings.otherlevels;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class OLOptions
extends NSObject {
    @Property(selector="developmentOptions")
    public static native OLOptions developmentOptions();

    @Property(selector="defaultOptions")
    public static native OLOptions defaultOptions();

    @Property(selector="notificationCallback")
    public native @Block OtherLeveles.OLNotificationBlock notificationCallback();

    @Property(selector="appKey")
    public native String getAppKey();

    @Property(selector="deviceId")
    public native String getDeviceId();

    @Property(selector="portfolioAppKey")
    public native String getPortfolioAppKey();

    @Property(selector="handleApplicationEvents")
    public native boolean handleApplicationEvents();

    @Property(selector="handleBackgroundFetch")
    public native boolean handleBackgroundFetch();

    @Property(selector="strictValidation")
    public native boolean strictValidation();
}