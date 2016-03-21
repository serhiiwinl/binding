
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