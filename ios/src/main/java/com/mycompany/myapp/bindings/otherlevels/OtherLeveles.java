package com.mycompany.myapp.bindings.otherlevels;

import com.mycompany.myapp.bindings.otherlevels.OLOptions;
import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UILocalNotification;
import org.robovm.apple.uikit.UIUserNotificationSettings;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.rt.bro.ValuedEnum;

/**
 * Created by sliubetskyi on 3/21/16.
 */
@NativeClass
public class OtherLeveles extends NSObject {

    public static interface OLNotificationBlock {
        public void invoke(OLNotificationType notifType, NSDictionary<?, ?> dictionary);
    }

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



    @Method(selector="startSessionWithLaunchOptions:andOLOptions:")
    public static native void startSessionWithLaunchOptions(NSDictionary<?, ?> var0, OLOptions var1);

    @Method(selector="startSessionWithLaunchOptions:")
    public static native void startSessionWithLaunchOptions(NSDictionary<?, ?> var0);

    @Method(selector="delayedStartedSessionWithOLOptions:")
    public static native void delayedStartedSessionWithOLOptions(OLOptions var0);

    @Method(selector="didReceiveNotification:notification:")
    public static native void didReceiveNotification(UIApplication var0, NSDictionary<?, ?> var1);

    @Method(selector="didAcceptLocalNotification:notification:")
    public static native void didAcceptLocalNotification(UIApplication var0, UILocalNotification var1);

    @Method(selector="didRegisterUserNotificationSettings:")
    public static native void didRegisterUserNotificationSettings(UIUserNotificationSettings var0);

    @Method(selector="setTrackingID:")
    public static native void setTrackingID(String var0);

    @Method(selector="setTrackingID:withPortfolioTrackingId:")
    public static native void setTrackingID(String var0, String var1);

    @Method(selector="getAppKey:")
    public static native String getAppKey();

    @Method(selector="getDeviceId:")
    public static native String getDeviceId();

    @Method(selector="getDeviceToken:")
    public static native String getDeviceToken();

    @Method(selector="getPortfolioTrackingId:")
    public static native String getPortfolioTrackingId();

    @Method(selector="getPortfolioAppKey:")
    public static native String getPortfolioAppKey();

    @Method(selector="setPortfolioAppKey:")
    public static native void setPortfolioAppKey(String var0);

    @Method(selector="registerDevice:")
    public static native void registerDevice(String var0);

    @Method(selector="registerDevice:withTags:")
    public static native void registerDevice(String var0, NSArray<NSDictionary<?, ?>> var1);

    @Method(selector="unregisterDevice:withTags:")
    public static native void unregisterDevice(String var0);

    @Method(selector="getTagValueForTagName:value:")
    public static native void getTagValueForTagName(String var0, @Block VoidBlock1<String> var1);

    @Method(selector="setTagValueForTagName:value:type:")
    public static native void setTagValueForTagName(String var0, String var1, String var2);

    @Method(selector="batchSetTags:")
    public static native void batchSetTags(NSArray<NSDictionary<?, ?>> var0);

    @Method(selector="deleteAllTags:")
    public static native void deleteAllTags();
}
