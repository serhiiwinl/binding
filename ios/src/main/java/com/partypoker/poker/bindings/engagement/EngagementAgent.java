package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sliubetskyi on 4/21/16.
 */
@NativeClass
public class EngagementAgent extends NSObject {
    /**
     * This information is used so that the backend can recognized your application.
     * Call this method when the application starts.
     *
     * @param connectionString The Engagement connection URL must match the following format:
     *                         `Endpoint={YOUR_APP_COLLECTION.DOMAIN};SdkKey={YOUR_APPID};AppId={YOUR_APPID}`
     */
    //+ (void)init:(NSString*)connectionString;
    @Method(selector = "init:")
    public static native void init(String connectionString);

    /**
     * Register application with the given connection string associated to the
     * application.
     * Also register optional Engagement modules (See module documentation for more
     * information).
     *
     * @param connectionString The Engagement connection URL must match the following format:
     *                         `Endpoint={YOUR_APP_COLLECTION.DOMAIN};SdkKey={YOUR_APPID};AppId={YOUR_APPID}`
     * @param firstModule      Optional Engagement module.
     * @param //...            A comma-separated list of Engagement modules.
     */
    // + (void)init:(NSString*)connectionString modules:(id<AEModule>)firstModule, ...;
    @Method(selector = "init:modules:")
    public static native void init(String connectionString, AEModule... firstModule);

    /**
     * Register application with the given connection string associated to the
     * application.
     * Also register optional Engagement modules (See module documentation for more
     * information).
     * This is a convenient method for Swift compatibility purpose.
     *
     * @param connectionString The Engagement connection URL must match the following format:
     *                         `Endpoint={YOUR_APP_COLLECTION.DOMAIN};SdkKey={YOUR_APPID};AppId={YOUR_APPID}`
     * @param modules          Array of optional Engagement modules.
     */
    //+ (void)init:(NSString*)connectionString modulesArray:(NSArray*)modules;
    @Method(selector = "init:modulesArray:")
    public static native void init(String connectionString, NSArray<?> modules);


    /**
     * ---------------------
     * @name General options
     * ---------------------
     */

    /**
     * Engagement agent can be configured to produce test logs.
     *
     * @param value Set to YES to enable test logs, NO otherwise.
     */
    //+ (void)setTestLogEnabled:(BOOL)value;
    @Method(selector = "setTestLogEnabled:")
    public static native void setTestLogEnabled(boolean value);

    /**
     * Enable or disable the agent. The change is persistent. As an example you
     * don't need to call
     * this function every time the application is launched to disable the agent.
     * <p/>
     * You can also integrate this setting in your `Settings.bundle` file using the
     * key 'engagement_agent_enabled'
     * (also available as a constant string: `kEngagementAgentEnabled`).
     *
     * @param enabled Set to YES to enable the agent, NO otherwise.
     *                //@see enabled
     */
    //- (void)setEnabled:(BOOL)enabled;
    @Method(selector = "setEnabled:")
    public native void setEnabled(boolean enabled);

    /**
     * Set the delay between each burst of analytics reported to the backend.
     * Passing a value equal to
     * or below 0 means that analytics are reported in real time. Default value is
     * 0.
     *
     * @param threshold Delay in seconds between each analytic burst.
     */
    //- (void)setBurstThreshold:(double)threshold;
    @Method(selector = "setBurstThreshold:")
    public native void setBurstThreshold(Double threshold);


    /**
     * By default, Engagement Agent will report your application crashes. If you want to
     * disable crash reports, you can
     * use this function.
     *
     * @param enabled Set to NO to disable crash reports, YES otherwise (default
     *                value).
     * @attention If you disable crash reports, the Engagement session will not be
     * closed when the application gets killed
     * abruptly.
     */
    //- (void)setCrashReport:(BOOL)enabled;
    @Method(selector = "setCrashReport:")
    public native void setCrashReport(boolean enabled);
}
