
package com.mycompany.myapp.bindings.otherlevels;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.ValuedEnum;

@NativeClass
public class OLOptions
extends NSObject {

    public static enum OLNotificationType implements ValuedEnum {
        OLRemoteNotificationType(0),
        OLLocalNotificationType(1);

        private final long n;

        private OLNotificationType(long n) {
            this.n = n;
        }

        public long value() {
            return 0;
        }
    }

    public static interface OLNotificationBlock {
        public void invoke(OLNotificationType notificationType, NSDictionary<?, ?> userInfo);
    }

    @Property(selector="developmentOptions")
    public static native OLOptions developmentOptions();

    @Property(selector="defaultOptions")
    public static native OLOptions defaultOptions();

    @Property(selector="notificationCallback")
    public native @Block OLNotificationBlock notificationCallback();

    @Property(selector="appKey")
    public native String getAppKey();

    @Property(selector="setAppKey:")
    public native void setAppKey(String appKey);

    @Property(selector="deviceId")
    public native String getDeviceId();

    @Property(selector="setDeviceId:")
    public native void setDeviceId(String deviceId);

    @Property(selector="portfolioAppKey")
    public native String getPortfolioAppKey();

    @Property(selector="setPortfolioAppKey:")
    public native void setPortfolioAppKey(String portfolioAppKey);

    @Property(selector="handleApplicationEvents")
    public native boolean getHandleApplicationEvents();

    @Property(selector="setHandleApplicationEvents:")
    public native void setHandleApplicationEvents(boolean handleApplicationEvents);

    @Property(selector="handleBackgroundFetch")
    public native boolean getHandleBackgroundFetch();

    @Property(selector="setHandleBackgroundFetch:")
    public native void setHandleBackgroundFetch(boolean handleBackgroundFetch);

    @Property(selector="strictValidation")
    public native boolean getStrictValidation();

    @Property(selector="setStrictValidation:")
    public native void setStrictValidation(boolean strictValidation);
}