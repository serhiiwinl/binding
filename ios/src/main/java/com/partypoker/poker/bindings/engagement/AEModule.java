package com.partypoker.poker.bindings.engagement;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSObjectProtocol;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

/**
 * Created by sliubetskyi on 4/21/16.
 */
@NativeClass
public interface AEModule extends NSObjectProtocol {

    /**
     * The `AEModule` protocol defines an interface for Engagement modules
     *
     * You can pass a module in the Engagement initialization method.
     *
     * **Related methods**
     *
     * - <[EngagementAgent init:modules:]>
     * - <[EngagementAgent getModule:]>
     */
//    @protocol AEModule<NSObject>

    /**
     * Start module.
     * This method is called by the <EngagementAgent> when Engagement has been initialized.<br>
     * You can start using Engagement agent methods at this point.
     */
    //- (void)start;
    @Method(selector = "start:")
    void start();


    /**
     * Stop module.
     * This method is called by the <EngagementAgent> when Engagement is going to be released.<br>
     * You should release uneeded resources in this method. You won't be able to call any methods from the <EngagementAgent>
     * after this point.
     */
    //- (void)stop;
    @Method(selector = "stop:")
    void stop();

    /**
     * The unique name of the module
     */
    //- (NSString*)name;
    @Method(selector = "name:")
    String name();


    //@optional

    /**
     * Called when a push message is received by Engagement.
     * This does not include the push message if it has been received following application launch
     * It stores the message locally and tried to process the message. If app is in the background,
     * message is processed once app becomes active.
     *
     * @param msg The push message.
     * @see AEPushMessage
     */
    //- (void)pushMessageReceived:(AEPushMessage*)msg;
    @Method(selector = "pushMessageReceived:")
    void pushMessageReceived(AEPushMessage msg);

    /**
     * Called when remote notification is received.
     *
     * @param userInfo The notification object.
     */
    //- (void)processRemoteNotification:(NSDictionary*)userInfo;
    @Method(selector = "processRemoteNotification:")
    void processRemoteNotification(NSDictionary<?, ?> userInfo);

    /**
     * Called when message with downloadble content is downloaded.
     *
     * @param message Downloaded message.
     */
    //- (void)dlcDownloaded:(AEPushMessage*)message;
    @Method(selector = "dlcDownloaded:")
    void dlcDownloaded(AEPushMessage message);

    /**
     * Called when content of a message has failed to download.
     *
     * @param messageId Message Id.
     */
    //- (void)dlcDownloadFailed:(NSString*)messageId;
    @Method(selector = "dlcDownloadFailed:")
    void dlcDownloadFailed(String messageId);

    /**
     * Called when campaigns are polled.
     *
     * @param campaigns Polled campaigns.
     */
    //- (void)campaignsPolled:(NSArray*)campaigns;
    @Method(selector = "campaignsPolled:")
    void campaignsPolled(NSArray<?> campaigns);

    /**
     * Called when failed to poll campaigns.
     */
    //- (void)campaignsPollFailed;
    @Method(selector = "campaignsPollFailed:")
    void campaignsPollFailed();

    /**
     * Called when Engagement has detected that the current activity has changed.
     *
     * @param activityName The name of the new activity.
     */
    //- (void)activityChanged:(NSString*)activityName;
    @Method(selector = "activityChanged:")
    void activityChanged(String activityName);

    /**
     * Called when an Apple push notification is received.
     *
     * @param notification The notification payload.
     */
    //- (void)pushNotificationReceived:(NSDictionary*)notification;
    @Method(selector = "pushNotificationReceived:")
    void pushNotificationReceived(NSDictionary<?, ?> notification);

    /**
     * Called when the deviceid or the appid has changed.
     * You should use this method to clear the storage, for example.
     * Careful : The module is not started yet.
     */
    //- (void)configurationChanged;
    @Method(selector = "configurationChanged:")
    void configurationChanged();

}
