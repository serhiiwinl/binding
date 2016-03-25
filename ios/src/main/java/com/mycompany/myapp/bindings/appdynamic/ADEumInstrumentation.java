package com.mycompany.myapp.bindings.appdynamic;

import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sliubetskyi on 3/24/16.
 */
@NativeClass
public class ADEumInstrumentation {

    @Property(selector = "initWithKey:collectorUrl:")
    public static native void initWithKey(String appKey, String collectorUrl);

    @Property(selector = "initWithKey:")
    public static native void initWithKey(String appKey);

}
