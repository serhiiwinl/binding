//
//  OtherLevels.h
//  OtherLevels
//
//  Copyright 2011-2015 OtherLevels. All rights reserved.
//

/**
 * Cannot use modules due to requiring support for C++ within Unity projects.
 */

#ifndef OtherLevels_Library_Version
#define OtherLevels_Library_Version @"1.4.1.4"

#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

#import "OLOptions.h"
#import "OLRichInboxMessage.h"
#import "OLRichInboxTileCardViewController.h"
#import "OLRichInboxBannerCardViewController.h"
#import "OLRichInboxBannerCardView.h"
#import "OLViewConfig.h"

@protocol InterstitialInfo;


/**
 * Main library class
 */
@interface OtherLevels : NSObject

#pragma mark -
#pragma mark start session

/**
 * Use the method to initialise and start the Otherlevels library
 * @param launchOptions 
 * @param options
*/

+ (void)startSessionWithLaunchOptions:(NSDictionary *)launchOptions andOLOptions:(OLOptions *) option;

/**
 * Use the method to initialise Otherlevels library
 */
+ (void) initSessionWithLaunchOptions:(NSDictionary *)launchOptions;

/**
 * Use the method to start the
 */

+ (void) delayedStartedSessionWithOLOptions:(OLOptions*) option;


/**
 * Use this method to set your portfolio app key if you have not already entered it into your app's info.plist.
 * @param portfolioAppKey Your portfolio application key from your OtherLevels account.
 */
+ (void)setPortfolioAppKey:(NSString *)portfolioAppKey;

#pragma mark -
#pragma mark RemoteNotificationHandling

/**
 * Used as a placeholder currently for future features when a notification is delivered while the application is running in foreground
 * Call from within UIApplicationDelegate didReceiveNotification with same parameters to track a push open
 * @param application The UIApplication from the parent
 * @param notification The notification from the parent
 */
+ (void)didReceiveNotification:(UIApplication*)application notification:(NSDictionary*)notification;

#pragma mark -
#pragma mark LocalNotificationHandling

/**
 * Call from within UIApplicationDelegate didAcceptLocalNotification with same parameters to track a local push open
 * @param application The UIApplication from the parent
 * @param notification The notification from the parent
 */
+ (void)didAcceptLocalNotification:(UIApplication*)application notification:(UILocalNotification*)notification;


+ (void)didRegisterUserNotificationSettings:(UIUserNotificationSettings *)notificationSettings;

#pragma mark -
#pragma mark TrackingId

/**
 * Associate a trackingId with a device. This allows the devices to be tracked on an individual basis and still hold a reference for retargeting
 * @param trackingId The trackingId of the user, usually and email, accountId or account hash to help send retargeted messages to a device
 */ 
+ (void)setTrackingID:(NSString*)trackingId;

/**
 * Associate a trackingId and portfolio trackingId with a device. This allows the devices to be tracked on an individual basis and still hold a reference for retargeting
 * @param trackingId The trackingId of the user, usually and email, accountId or account hash to help send retargeted messages to a device
 * @param portfolioTrackingId The portfolio trackingId of the user, a global identifier to use between apps.
 */
+ (void)setTrackingID:(NSString*)trackingId withPortfolioTrackingId:(NSString *)portfolioTrackingId;

/**
 * Returns the trackingId of the associated device.
 * @returns the trackingId of the user, usually and email, accountId or account hash to help send retargeted messages to a device
 */
+ (NSString *)getTrackingId;

/**
 * Returns the appKey which was configured against the OtherLevels session.
 * Will only have a value after starting a session.
 */
+ (NSString *)getAppKey;

/**
 * Returns the deviceId which was configured against the OtherLevels session.
 * Will only have a value after starting a session.
 */
+ (NSString *)getDeviceId;

/**
 * Returns the device token which was configured against the OtherLevels session.
 * Will only have a value after starting a session, and the device has been registered for push
 * notifications.
 */
+ (NSString *)getDeviceToken;

/**
 * Returns the portfolio tracking identifier of the associated device.
 * @returns the trackingId of the user, usually and email, accountId or account hash to help send retargeted messages to a device
 */
+ (NSString *)getPortfolioTrackingId;

/**
 * Returns the portfolio appkey which was configured against the OtherLevels session.
 * Will only have a value after starting a session.
 */
+ (NSString *)getPortfolioAppKey;


#pragma mark -
#pragma mark InAppSessionStart

/**
 * Register a phash assigned to an in App alert or interstitial
 * @param phash The phash from the split associated with the message or nil if phash failed
 */
+ (void)pushPhashForTracking:(NSString*)phash;

/**
 * Track a message open from an in App alert or interstitial, uses the last phash pushed into the tracking list
 */
+ (void)trackLastPhashOpen;

#pragma mark -
#pragma mark EventHandling

/**
 * Register an event for the session
 * @param eventType The type of event (should be an explanative top level ie. overview, purchase, registered, opened)
 * @param eventLabel The event label (should be a more descriptive label ie. Purchased Magic Beans $5.99 package)
 */
+ (void)registerEvent:(NSString*)eventType label:(NSString*)eventLabel;

/**
 * Register an event for the session with phash
 * @param eventType The type of event (should be an explanative top level ie. overview, purchase, registered, opened)
 * @param eventLabel The event label (should be a more descriptive label ie. Purchased Magic Beans $5.99 package)
 * @param phash The phash passed in separately with the event call
 */
+ (void)registerEvent:(NSString*)eventType label:(NSString*)eventLabel phash:(NSString*)phash;

#pragma mark -
#pragma mark DeviceInitiatedPushes

/**
 * This call is used to perform a split test and phash generation for pushes initiated from the device
 * @param notification The message to perform a split test on
 * @param campaign The campaignToken to track the push under
 * @param block The block to execute when the split has been fulfilled - this block should physically send the push. Phash could be nil in case of network outage
 */
+ (void)splitTestNotification:(NSString*)notification campaign:(NSString*)campaign pushSend:(void(^)(NSString* message, NSString* phash, NSData *content))block;

#pragma mark -
#pragma mark LocalNotifications

/**
 * Clear all local notifications that haven't been been delivered yet
 */
+ (void)clearLocalNotificationsPending;

/**
* Clear single local notifications that has not yet been delivered
*/

+(void) clearLocalNotificationPending:(UILocalNotification *) notification;

/**
 * Perform a split test and schedule a local notification
 * @param notification The message to perform a split test on
 * @param badge The badge to set the app to
 * @param campaign The campaignToken to track the push under
 * @param date The date to show the notification
 */
+ (UILocalNotification *)scheduleLocalNotification:(NSString*)notification badge:(int)badge campaign:(NSString*)campaign date:(NSDate*)date;

/**
 * Perform a split test and schedule a local notification
 * @param notification The message to perform a split test on
 * @param badge The badge to set the app to
 * @param campaign The campaignToken to track the push under
 * @param date The date to show the notification
 * @param userInfo A dictionary(key-value pairs) for passing custom information to the notified application.
 */
+ (UILocalNotification *)scheduleLocalNotification:(NSString*)notification badge:(int)badge campaign:(NSString*)campaign date:(NSDate*)date userInfo:(NSDictionary*)userInfo;

/**
 * Perform a split test and schedule a local notification
 * @param notification The message to perform a split test on
 * @param badge The badge to set the app to
 * @param action The name of the action button to show
 * @param campaign The campaignToken to track the push under
 * @param date The date to show the notification
 */
+ (UILocalNotification *)scheduleLocalNotification:(NSString*)notification badge:(int)badge action:(NSString*)action campaign:(NSString*)campaign date:(NSDate*)date;

/**
 * Perform a split test and schedule a local notification
 * @param notification The message to perform a split test on
 * @param badge The badge to set the app to
 * @param action The name of the action button to show
 * @param campaign The campaignToken to track the push under
 * @param date The date to show the notification
 * @param userInfo A dictionary(key-value pairs) for passing custom information to the notified application.
 */
+ (UILocalNotification *)scheduleLocalNotification:(NSString*)notification badge:(int)badge action:(NSString*)action campaign:(NSString*)campaign date:(NSDate*)date userInfo:(NSDictionary*)userInfo;

#pragma mark -
#pragma mark Push (Remote) Notifications

/**
 * Register a device with OtherLevels push service
 * @param deviceToken The deviceToken of the device

 */
+ (void)registerDevice:(NSString*)deviceToken;

/**
 * Register a device with OtherLevels push service
 * @param deviceToken The deviceToken of the device
 * @param tags Any tags to tag the registered user/device (An NSArray of NSDictionary tag objects. Each tag is an NSDictionary object with name:value, value:value, type:value) Example: ({name = city; type = string; value = Brisbane;}, {name = time; type = timestamp; value = 1356998412000;}, {name = age; type = numeric; value = 25;}) 
 */
+ (void)registerDevice:(NSString*)deviceToken withTags:(NSArray*)tags;

/**
 * UnRegister a device from OtherLevels push service, this puid will no longer receive pushes for that puid, nil puids will no longer receive broadcasts
 * @param deviceToken The deviceToken of the device
 */
+ (void)unregisterDevice:(NSString*)deviceToken;

#pragma mark -
#pragma mark GeoLocation

/**
 * Send the users current location
 * @param currentLocation The CLLocation object which represents the location data
 */
+ (void)geoLocationUpdate:(CLLocation*)currentLocation;

#pragma mark -
#pragma mark Tags

/**
 * Get the tag value for a tag name associated with a trackingId
 * @param tagName The tag name associated with the trackingId
 * @param value The block to execute when the get tagValue is returned. TagValue could be nil when the tagName does not exist
 */
+ (void)getTagValueForTagName:(NSString*)tagName value:(void(^)(NSString* tagValue))valueBlock;

/**
 * Set the tag value for a tag name associated with a trackingId
 * @param tagName The tag name associated with the trackingId
 * @param tagValue The tag Value that is set
 * @param tagType The datatype of the Value that is set (send as "numeric" OR "string" OR "timestamp" only depending on your value)
   Example1: To pass in tagName:Age, send in tagValue:25, send in tagType:numeric (all passed in as strings)
   Example2: To pass in tagName:City, send in tagValue:London, send in tagType:string (all passed in as strings)
   Example3: To pass in tagName:Time, send in tagValue:1356998412000 (Needs to be UnixTimeStamp in milliseconds - [[NSDate date] timeIntervalSince1970] * 1000), send in tagType:timestamp (all passed in as strings)
 */
+ (void)setTagValueForTagName:(NSString*)tagName value:(NSString*)tagValue type:(NSString*)tagType;

/**
 * Set a batch of tag values for a trackingId
 * @param tags Any tags to tag the user/device (An NSArray of NSDictionary tag objects. Each tag is an NSDictionary object with name:value, value:value, type:value) Example: ({name = city; type = string; value = Brisbane;}, {name = time; type = timestamp; value = 1356998412000;}, {name = age; type = numeric; value = 25;}) 
 */
+ (void)batchSetTags:(NSArray*)tags;

/**
 * Delete all existing tags for a trackingId
 */
+ (void)deleteAllTags;

#pragma mark -
#pragma mark Interstitial

/**
 * Interstitial placement keys which correspond to the interstitial placements in portal.
 */

+ (NSString *)INTERSTITIAL_PLACEMENT_APP_OPEN;
+ (NSString *)INTERSTITIAL_PLACEMENT_FEEDBACK;
+ (NSString *)INTERSTITIAL_PLACEMENT_PUSH_OPEN;
+ (NSString *)INTERSTITIAL_PLACEMENT_STORE_LAUNCH;
+ (NSString *)INTERSTITIAL_PLACEMENT_1;
+ (NSString *)INTERSTITIAL_PLACEMENT_2;
+ (NSString *)INTERSTITIAL_PLACEMENT_3;
+ (NSString *)INTERSTITIAL_PLACEMENT_4;
+ (NSString *)INTERSTITIAL_PLACEMENT_5;
+ (NSString *)INTERSTITIAL_PLACEMENT_6;
+ (NSString *)INTERSTITIAL_PLACEMENT_7;
+ (NSString *)INTERSTITIAL_PLACEMENT_8;
+ (NSString *)INTERSTITIAL_PLACEMENT_9;
+ (NSString *)INTERSTITIAL_PLACEMENT_A;
+ (NSString *)INTERSTITIAL_PLACEMENT_B;
+ (NSString *)INTERSTITIAL_PLACEMENT_C;
+ (NSString *)INTERSTITIAL_PLACEMENT_D;
+ (NSString *)INTERSTITIAL_PLACEMENT_E;
+ (NSString *)INTERSTITIAL_PLACEMENT_F;

/**
 * This call is used to retrieve the an Interstitial message for a given placement.
 * @param placement The placement location, where the interstitial should be shown.  This is specified by using a placement key which exists on the OtherLevels class e.g. [OtherLevels INTERSTITIAL_PLACEMENT_STORE_LAUNCH].
 * @param interstitialViewController The interstitial view controller which the message content will be displayed within.
 * @param animated Pass YES to animate the presentation; otherwise, pass NO.
 */
+ (void) getInterstitialForPlacement:(NSString*)placement presentInterstitial:(UIViewController <InterstitialInfo> *)interstitialViewController animated:(BOOL)flag;

#pragma mark
#pragma mark - Rich Inbox

/**
* This call is used to retrieve the latest Rich Media Inbox messages

* @param messageListBlock The block to execute when a new message/messages are retrieved - this block returns the latest message/messages and the total unread count
*/
+ (void)getRichInboxMessagesList:(void(^)(NSArray *messages, NSUInteger unReadMessagesCount))messageListBlock;

/**
* This call is used to retrieve the latest Rich Media Inbox message directly
* @param notificationId The notification ID of the message that needs to be retrieved
* @param messageContent The block to execute when the message is retrieved - this block returns the message for the notification ID and the total unread count
*/
+ (void)getRichInboxMessage:(int)notificationId messageContent:(void(^)(OLRichInboxMessage *message, NSUInteger unReadMessagesCount))messageContent;

/**
* Update the message read status in your local Rich Media Inbox
* @param notificationId The notification ID of the message that gets updated
* @param readState The read state of the message
* @param phash The phash of the message
* @param completion The block to execute when a message is updated - this block returns the total unread count
*/
+ (void)updateRichInboxMessage:(int)notificationId phash:(NSString*)phash readState:(int)readState completion:(void(^)(NSUInteger unReadMessagesCount))completion;

/**
* Delete the message from your local Rich Media Inbox
* @param notificationId The notification ID of the message to delete
* @param phash The phash of the message
* @param completion The block to execute when a message is deleted - this block returns the total unread count
*/
+ (void)deleteRichInboxMessage:(int)notificationId phash:(NSString*)phash completion:(void(^)(NSUInteger unReadMessagesCount))completion;

#pragma mark -
#pragma mark permissions


extern NSString *const OLLocationPermisionGrantedNotification;
extern NSString *const OLLocationPermisionDeniedNotification;


typedef NS_ENUM(NSUInteger, OLPermission) {
    OLPermissionNotification,
    OLPermissionLocation,
    OLPermissionLocationInUse
};

/*
 * Prompts the user for a permission.
 */

+ (void) askForPermission:(OLPermission) permission;

#pragma mark -
#pragma mark start session methods deprecated methods

/**
 * Debug versions of the OL startSessionWithLaunchOptions Lib API with NSLogging enabled. Make sure the OL_App_Key is set in the info.plist file
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)debugSessionWithLaunchOptions:(NSDictionary *)launchOptions andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Debug versions of the OL startSessionWithLaunchOptions Lib API with NSLogging enabled. Make sure the OL_App_Key is set in the info.plist file
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param deviceId A custom deviceId to use for tracking purposes, usually an email, accountId or account hash to manage a user on multiple devices
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)debugSessionWithLaunchOptions:(NSDictionary *)launchOptions clientDeviceId:(NSString*)deviceId andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Debug versions of the OL startSessionWithAppKey Lib API with NSLogging enabled
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)debugSessionWithAppKey:(NSString*)appKey launchOptions:(NSDictionary *)launchOptions andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Debug versions of the OL startSessionWithAppKey Lib API with NSLogging enabled
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param deviceId A custom deviceId to use for tracking purposes, usually an email, accountId or account hash to manage a user on multiple devices
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)debugSessionWithAppKey:(NSString*)appKey launchOptions:(NSDictionary *)launchOptions clientDeviceId:(NSString*)deviceId andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Start a session and pass in the launch options for the App. Make sure the OL_App_Key is set in the info.plist file
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)startSessionWithLaunchOptions:(NSDictionary *)launchOptions andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Start a session and pass in the launch options for the App. Make sure the OL_App_Key is set in the info.plist file
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param clientDeviceId A custom deviceId to use for tracking purposes, usually an email, accountId or account hash to manage a user on multiple devices
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)startSessionWithLaunchOptions:(NSDictionary *)launchOptions clientDeviceId:(NSString*)deviceId andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Start a session with your AppKey and pass in the launch options for the App
 * @param appKey Your application key (String) from your OtherLevels.com account
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)startSessionWithAppKey:(NSString*)appKey launchOptions:(NSDictionary *)launchOptions andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

/**
 * Start a session with your AppKey and pass in the launch options for the App
 * @param appKey Your application key (String) from your OtherLevels.com account
 * @param launchOptions The launch options dictionary from the UIApplicationDelegate
 * @param clientDeviceId A custom deviceId to use for tracking purposes, usually an email, accountId or account hash to manage a user on multiple devices
 * @param locationUpdates A bool to indicate if the clients want geo Region monitoring
 * @param appOpenInterstitial The interstitial UIViewController to use for displaying app open interstitial notifications.
 */
+ (void)startSessionWithAppKey:(NSString*)appKey launchOptions:(NSDictionary *)launchOptions clientDeviceId:(NSString*)deviceId andLocationUpdates:(BOOL)locationUpdates withAppOpenInterstitial:(UIViewController <InterstitialInfo> *)appOpenInterstitial DEPRECATED_MSG_ATTRIBUTE("Use startSessionWithLaunchOptions:andOLOptions:");

+ (NSString *)ol_id;

@end

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#pragma mark -
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
* This protocol is implemented by a UIViewController which is to be used for an interstitial.
* @param htmlContent The interstitial's htmlContent to display within it's UIWebView.
* @param pHash The phash associated with the interstitial.
*/
@protocol InterstitialInfo <NSObject>

@property (strong) NSString *htmlContent;
@property (strong) NSString *pHash;
@optional @property (strong) NSDictionary *messageContent;

@end

#endif
