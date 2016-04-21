package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

/**
 * Created by sliubetskyi on 4/21/16.
 */
@NativeClass
public class AEPushMessage extends NSObject {
    /** Message's identifier */
    //@property(nonatomic, retain) NSString* messageId;
    @Property(selector = "messageId")
    public native String getMessageId();

    @Property(selector = "messageId:")
    public native void setMessageId(String messageId);

/** Reach values */
    //@property(nonatomic, retain) NSDictionary* reachValues;
    @Property(selector = "reachValues")
    public native NSDictionary<?,?> getReachValues();

    @Property(selector = "reachValues:")
    public native void setReachValues(NSDictionary<?,?> reachValues);

/** Message's payload */
    //@property(nonatomic, retain) NSDictionary* payload;
    @Property(selector = "payload")
    public native NSDictionary<?,?> getPayload();

    @Property(selector = "payload:")
    public native void setPayload(NSDictionary<?,?> reachValues);

/**
 * Parse payload data.
 * @param payloadData in NSData format.
 * @return Parsing error.
 */
    //- (NSError*)parseJsonPayload:(NSData*)payloadData;

    @Method(selector = "parseJsonPayload")
    public native NSError parseJsonPayload(NSData payloadData);

}
