package com.partypoker.poker.bindings.appdynamic;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@NativeClass
public class ADEumInstrumentation extends NSObject {

    ///---------------------
    /// @name Initialization
    ///---------------------

    /**
     * Initializes the SDK.
     * <p/>
     * This method should be called once, early in your application's startup sequence.
     *
     * @param appKey The application key.
     * @warning `appKey` must not be `nil`.
     */
    //+ (void)initWithKey:(NSString *)appKey;
    @Method(selector = "initWithKey:")
    public static native void initWithKey(String appKey);

    /**
     * Initializes the SDK.
     * <p/>
     * This method should be called once, early in your application's startup sequence.
     *
     * @param appKey       The application key.
     * @param collectorUrl The URL of the collector. The SDK will send beacons to this collector.
     * @warning `appKey` must not be `nil`.
     * @warning `collectorUrl` must not be `nil`. Otherwise, an NSInvalidArgumentException will be thrown.
     */
    //+ (void)initWithKey:(NSString *)appKey collectorUrl:(NSString *)collectorUrl;
    @Method(selector = "initWithKey:collectorUrl:")
    public static native void initWithKey(String appKey, String collectorUrl);


}
