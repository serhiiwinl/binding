package com.partypoker.poker.bindings.appdynamic;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@NativeClass
public class ADEumInstrumentation {

    @Method(selector = "initWithKey:collectorUrl:")
    public static native void initWithKey(String appKey, String collectorUrl);

    @Method(selector = "initWithKey:")
    public static native void initWithKey(String appKey);

}
