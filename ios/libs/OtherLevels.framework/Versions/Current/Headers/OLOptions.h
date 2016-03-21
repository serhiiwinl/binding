//
// Created by Richard BARGE on 22/05/15.
// Copyright (c) 2015 OtherLevels. All rights reserved.
//

#import <UIKit/UIKit.h>

@protocol InterstitialInfo;

typedef NS_ENUM(NSUInteger, OLNotificationType) {
    OLRemoteNotificationType,
    OLLocalNotificationType
};

typedef void(^OLNotificationBlock)(OLNotificationType notificationType,NSDictionary *userInfo);

@interface OLOptions : NSObject

/**
* Default options for development environment
*/
+ (OLOptions*)developmentOptions;

/**
 * Default options for production environment
 */
+ (OLOptions*)defaultOptions;

/**
* The notificationCallback will get invoked everytime a notifcation arrives, but only only handleApplicationEvents is enabled. 
* @param OLNotificationBlock
*/
@property (nonatomic,copy) OLNotificationBlock notificationCallback;

/**
 * Set your OtherLevel's application key here if it is not already set in your Info.plist
 * for the key OL_App_Key.
 */
@property (nonatomic,strong) NSString *appKey;

/**
 * If you have a custom device id to assign for the device, assign it here.
 */
@property (nonatomic,strong) NSString *deviceId;

/**
 * If you have a portfolio application key assigned for your suite of applications, assign it here.
 */
@property (nonatomic,strong) NSString *portfolioAppKey;

/**
 * If your app is enabled for location based updates, enable it here.
 */
//@property (nonatomic,assign) BOOL locationUpdatesEnabled;

/**
 * Set to NO here if you need to disable the OtherLevels SDK from handling UIApplicationDelegate events
 * and want to implement the calls manually.
 */
@property (nonatomic,assign) BOOL handleApplicationEvents;

/**
 * Set to NO here if you do not want the OtherLevels SDK to assign a minimumBackgroundFetchInterval
 * for your app on initialization of the sdk.
 */
@property (nonatomic,assign) BOOL handleBackgroundFetch;

/**
 * Set to YES if you want the sdk exit/exception on invalid configuration. Yes by default is development mode.
 */
@property (nonatomic,assign) BOOL strictValidation;


/**
 * If you are using an interstitial for app opens, assign your UIViewController here.
 */
@property (nonatomic,strong) UIViewController <InterstitialInfo> *appOpenInterstitial;

@end