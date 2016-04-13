/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.partypoker.poker.bindings.google;

/*<imports>*/

import com.partypoker.poker.bindings.google.analytics.GAITracker;
import com.partypoker.poker.bindings.google.apis.google.GGLContext;
import org.robovm.apple.foundation.NSExtensions;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Library;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library(Library.INTERNAL)/*</annotations>*/
/*<visibility>*//*</visibility>*/ class /*<name>*/GGLContextAnalyticsExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(GGLContextAnalyticsExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private GGLContextAnalyticsExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "tracker")
    public static native GAITracker getTracker(GGLContext thiz);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}