package com.partypoker.poker.bindings.otherlevels;

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

/**
 * Created by sliubetskyi on 3/21/16.
 */
@NativeClass
public class OtherLevels extends NSObject {

    @Method(selector = "startSessionWithLaunchOptions:andOLOptions:")
    public static native void startSessionWithLaunchOptions(NSDictionary<?, ?> launchOptions, OLOptions option);

    @Method(selector = "startSessionWithLaunchOptions:")
    public static native void startSessionWithLaunchOptions(NSDictionary<?, ?> launchOptions);

    @Method(selector = "delayedStartedSessionWithOLOptions:")
    public static native void delayedStartedSessionWithOLOptions(OLOptions option);

    @Method(selector = "didReceiveNotification:notification:")
    public static native void didReceiveNotification(UIApplication application, NSDictionary<?, ?> notification);

    @Method(selector = "didAcceptLocalNotification:notification:")
    public static native void didAcceptLocalNotification(UIApplication application, UILocalNotification notification);

    @Method(selector = "didRegisterUserNotificationSettings:")
    public static native void didRegisterUserNotificationSettings(UIUserNotificationSettings notificationSettings);

    @Method(selector = "setTrackingID:")
    public static native void setTrackingID(String trackingId);

    @Method(selector = "setTrackingID:withPortfolioTrackingId:")
    public static native void setTrackingID(String trackingId, String portfolioTrackingId);

    @Method(selector = "getAppKey:")
    public static native String getAppKey();

    @Method(selector = "getDeviceId:")
    public static native String getDeviceId();

    @Method(selector = "getDeviceToken:")
    public static native String getDeviceToken();

    @Method(selector = "getPortfolioTrackingId:")
    public static native String getPortfolioTrackingId();

    @Method(selector = "getPortfolioAppKey:")
    public static native String getPortfolioAppKey();

    @Method(selector = "setPortfolioAppKey:")
    public static native void setPortfolioAppKey(String portfolioAppKey);

    @Method(selector = "registerDevice:")
    public static native void registerDevice(String deviceToken);

    @Method(selector = "registerDevice:withTags:")
    public static native void registerDevice(String deviceToken, NSArray<NSDictionary<?, ?>> tags);

    @Method(selector = "unregisterDevice:withTags:")
    public static native void unregisterDevice(String deviceToken);

    @Method(selector = "getTagValueForTagName:value:")
    public static native void getTagValueForTagName(String tagName, @Block VoidBlock1<String> valueBlock);

    @Method(selector = "setTagValueForTagName:value:type:")
    public static native void setTagValueForTagName(String tagName, String tagValue, String tagType);

    @Method(selector = "batchSetTags:")
    public static native void batchSetTags(NSArray<NSDictionary<?, ?>> tags);

    @Method(selector = "deleteAllTags:")
    public static native void deleteAllTags();

    /**
     * Register an event for the session
     *
     * @param eventType  The type of event (should be an explanative top level ie. overview, purchase, registered, opened)
     * @param eventLabel The event label (should be a more descriptive label ie. Purchased Magic Beans $5.99 package)
     */
    @Method(selector = "addEventHandler:label")
    public static native void registerEvent(String eventType, String eventLabel);

    /**
     * Register an event for the session with phash
     *
     * @param eventType  The type of event (should be an explanative top level ie. overview, purchase, registered, opened)
     * @param eventLabel The event label (should be a more descriptive label ie. Purchased Magic Beans $5.99 package)
     * @param phash      The phash passed in separately with the event call
     */
    @Method(selector = "addEventHandler:label:phash")
    public static native void registerEvent(String eventType, String eventLabel, String phash);
}
