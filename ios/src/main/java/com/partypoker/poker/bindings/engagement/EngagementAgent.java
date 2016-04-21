package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIBackgroundFetchResult;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.block.VoidBlock1;

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
     * Returns the singleton instance of the Engagement agent.
     */
    //+ (EngagementAgent*)shared;
    @Method(selector = "shared:")
    public static native EngagementAgent shared();

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

/**
 * -------------------------------------------
 * @name Reporting your application statistics
 * -------------------------------------------
 */

    /**
     * Report the current activity. A session is broken down into a sequence of
     * activities, this call attach the current
     * activity to the current session. If there is currently no session, this call
     * also starts a new session and the activity will be attached to the newly
     * created session.
     *
     * @param activityName The name of the current activity within the session, can
     *                     be nil for
     *                     default name (but not empty). Name is limited to 64 characters.
     * @param extras       The extra details associated with the activity. Keys must match
     *                     the
     *                     `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *                     before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)startActivity:(NSString*)activityName extras:(NSDictionary*)extras;
    @Method(selector = "startActivity:extras:")
    public native EngagementAgent startActivity(String activityName, NSDictionary<?, ?> extras);

    /**
     * Report that the current activity ended. This will close the session.
     */
    //- (void)endActivity;
    @Method(selector = "endActivity:")
    public native void endActivity();

    /**
     * Start a job.
     *
     * @param name   Job name, this should be unique, e.g. two jobs with the same
     *               name can't run at the same time, subsequent requests with the same
     *               name will end the previous job before starting the new one.
     *               Name is limited to 64 characters and cannot be empty.
     * @param extras The extra details associated with this job. Keys must match the
     *               `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *               before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)startJob:(NSString*)name extras:(NSDictionary*)extras;
    @Method(selector = "startJob:extras:")
    public native void startJob(String name, NSDictionary<?, ?> extras);

    /**
     * End a job.
     *
     * @param name The name of job that has been started with
     *             startJob:extras:
     */
    //- (void)endJob:(NSString*)name;
    @Method(selector = "endJob:")
    public native void endJob(String name);

    /**
     * Send an event to the backend.
     *
     * @param name   Event name/tag. Name is limited to 64 characters and cannot be
     *               empty.
     * @param extras The extra details associated with this event. Keys must match
     *               the
     *               `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *               before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendEvent:(NSString*)name extras:(NSDictionary*)extras;
    @Method(selector = "sendEvent:extras:")
    public native void sendEvent(String name, NSDictionary<?, ?> extras);

    /**
     * Send an event related to the current session. This has no effect if the
     * session has not been started.
     *
     * @param name   Event name/tag. Name is limited to 64 characters and cannot be
     *               empty.
     * @param extras The extra details associated with this event. Keys must match
     *               the
     *               `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *               before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendSessionEvent:(NSString*)name extras:(NSDictionary*)extras;
    @Method(selector = "sendSessionEvent:extras:")
    public native void sendSessionEvent(String name, NSDictionary<?, ?> extras);

    /**
     * Send an event related to a running job. This has no effect if no job is
     * running for the specified name.
     *
     * @param name    Event name/tag. Name is limited to 64 characters and cannot be
     *                empty.
     * @param jobName Job name.
     * @param extras  The extra details associated with this event. Keys must match
     *                the
     *                `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *                before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendJobEvent:(NSString*)name jobName:(NSString*)jobName extras:(NSDictionary*)extras;
    @Method(selector = "sendJobEvent:jobName:extras:")
    public native void sendJobEvent(String name, String jobName, NSDictionary<?, ?> extras);

    /**
     * Send an error to the backend.
     *
     * @param name   Error name/tag. Name is limited to 64 characters and cannot be
     *               empty.
     * @param extras The extra details associated with this error. Keys must match
     *               the
     *               `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *               before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendError:(NSString*)name extras:(NSDictionary*)extras;
    @Method(selector = "sendError:extras:")
    public native void sendError(String name, NSDictionary<?, ?> extras);

    /**
     * Send an error related to the current session. This has no effect if the
     * session has not been started.
     *
     * @param name   Error name/tag. Name is limited to 64 characters and cannot be
     *               empty.
     * @param extras The extra details associated with this error. Keys must match
     *               the
     *               `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *               before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendSessionError:(NSString*)name extras:(NSDictionary*)extras;
    @Method(selector = "sendSessionError:extras:")
    public native void sendSessionError(String name, NSDictionary<?, ?> extras);

    /**
     * Send an error related to a running job. This has no effect if no job is
     * running for the specified name.
     *
     * @param name    Error name/tag. Name is limited to 64 characters and cannot be
     *                empty.
     * @param jobName Job name.
     * @param extras  The extra details associated with this error. Keys must match
     *                the
     *                `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *                before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendJobError:(NSString*)name jobName:(NSString*)jobName extras:(NSDictionary*)extras;
    @Method(selector = "sendJobError:jobName:extras:")
    public native void sendJobError(String name, String jobName, NSDictionary<?, ?> extras);

/**
 * ------------------------------------------------
 * @name Reporting specific application information
 * ------------------------------------------------
 */

    /**
     * Send application specific information.
     *
     * @param info Application information as a dictionary. Keys must match the
     *             `^[a-zA-Z][a-zA-Z_0-9]*` regular expression. Extras are encoded into JSON
     *             before being sent to the server, the encoded limit is 1024 characters.
     */
    //- (void)sendAppInfo:(NSDictionary*)info;
    @Method(selector = "sendAppInfo:")
    public native void sendAppInfo(NSDictionary<?, ?> info);

/**
 * ----------------------
 * @name Sending messages
 * ----------------------
 */

    /**
     * Send a feedback to reach. You don't need to call this function directly, it's
     * used only by the optional reach module
     * to report feedback from announcements, polls and data pushes.
     *
     * @param feedback A dictionary containing the feedback payload to send.
     */
    //- (void)sendReachFeedback:(NSDictionary*)feedback;
    @Method(selector = "sendReachFeedback:")
    public native void sendReachFeedback(NSDictionary<?, ?> feedback);

/**
 * ------------------------------------
 * @name Listening to incoming messages
 * ------------------------------------
 */

/**
 * ---------------------------------
 * @name Getting Engagement agent data
 * ---------------------------------
 */

    /**
     * Get the identifier used by Engagement agent to identify this device.
     *
     * @result The identifier used by Engagement agent to identify this device.
     */
    //- (NSString*)deviceId;
    @Method(selector = "deviceId:")
    public native String deviceId();

    /**
     * Get a previously registered module.
     *
     * @param moduleName the name of the module to retrieve.
     * @result A Engagement agent module or nil if there is no module with that name.
     */
    //- (id<AEModule>)getModule:(NSString*)moduleName;
    @Method(selector = "getModule:")
    public native AEModule getModule(String moduleName);

    /**
     * Check if the agent is enabled.
     *
     * @result YES if the agent is enabled, NO otherwise.
     * //@see setEnabled:
     */
    //- (BOOL)enabled;
    @Method(selector = "enabled:")
    public native boolean enabled();

/**
 * --------------------------------
 * @name Apple push related methods
 * --------------------------------
 */

    /**
     * Register the device token returned by Apple servers.
     * This method is necessary to receive Apple push notifications from Engagement agent
     * Push Service.
     *
     * @param token Data as returned by the application delegate callback:
     *              - application:didRegisterForRemoteNotificationsWithDeviceToken:
     */
    //- (void)registerDeviceToken:(NSData*)token;
    @Method(selector = "registerDeviceToken:")
    public native void registerDeviceToken(NSData token);

    /**
     * If you are using the Engagement agent Push Service or Reach module,
     * you should call this function from the application delegate:
     * - application:didReceiveRemoteNotification:fetchCompletionHandler:
     *
     * @param userInfo          A dictionary that contains information related to the remote
     *                          notification
     * @param completionHandler The block to execute when the download operation is completed.
     *                          Our SDK will pass in the fetch result value that best describes the results of the download operation.
     *                          If you want your application to manually handle completion, you can pass nil for this parameter and handle the completion in your delegate method.
     * @see UIBackgroundFetchResult
     */
    //- (void)applicationDidReceiveRemoteNotification:(NSDictionary *)userInfo fetchCompletionHandler:(void (^)(UIBackgroundFetchResult result))completionHandler;
    @Method(selector = "applicationDidReceiveRemoteNotification:fetchCompletionHandler:")
    public native void applicationDidReceiveRemoteNotification(NSDictionary<?, ?> userInfo,
                                                               @Block VoidBlock1<UIBackgroundFetchResult> completionHandler);

    /**
     * Download the downloadable content.
     *
     * @param msgId Message dlc id
     */
    //- (void)getMessage:(NSString*)msgId;
    @Method(selector = "getMessage:")
    public native void getMessage(String msgId);

    /**
     * Get campaigns activated within certain time frame
     *
     * @param timeFrame The target time frame.
     */
    //- (void)getCampaigns:(NSNumber*)timeFrame;
    @Method(selector = "getCampaigns:")
    public native void getCampaigns(Number timeFrame);
}
