//
//  OLRichInboxBannerCardViewController.h
//  OtherLevels
//
//  Created by Gavin Bunney on 20/02/2015.
//  Copyright (c) 2015 OtherLevels. All rights reserved.
//

#import <UIKit/UIKit.h>


typedef void (^OLRichInboxBannerCardViewControllerDisplayBlock)(void);

@interface OLRichInboxBannerCardViewController : UIViewController

/**
 * Optional: Block to call when the banner will be displayed.
 * This is where you would hook in to make appropriate container changes
 * to accommodate the banner that will be animated in.
 */
@property (nonatomic, copy) OLRichInboxBannerCardViewControllerDisplayBlock bannerWillDisplay;

/**
 * Optional: Block to call when the banner has been displayed.
 */
@property (nonatomic, copy) OLRichInboxBannerCardViewControllerDisplayBlock bannerDidDisplay;

/**
 Optional: Load the message detail view when the banner is clicked. Otherwise display the card view Default YES
 */
@property(nonatomic,assign) BOOL forwardToDetail;

/**
 * Helper to quickly attach the banner to the bottom of the given view controller.
 * The banner card is added as a child controller with auto layout constraints.
 */
- (void)attachToBottomOfView:(UIViewController*)viewController;





@end
