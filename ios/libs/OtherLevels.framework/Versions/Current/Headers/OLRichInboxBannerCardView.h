//
//  OLRichInboxBannerCardView.h
//  OtherLevels
//
//  Created by Richard BARGE on 19/05/2015.
//  Copyright (c) 2015 OtherLevels. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef void (^OLRichInboxBannerCardViewDisplayBlock)(void);

IB_DESIGNABLE
@interface OLRichInboxBannerCardView : UIView

/**
Optional: Load the message detail view when the banner is clicked. Otherwise display the card view Default YES
*/
@property(nonatomic,assign) BOOL forwardToDetail;

/**
* Optional: Block to call when the banner will be displayed.
* This is where you would hook in to make appropriate container changes
* to accommodate the banner that will be animated in.
*/
@property (nonatomic, copy) OLRichInboxBannerCardViewDisplayBlock bannerWillDisplay;

/**
* Optional: Block to call when the banner has been displayed.
*/
@property (nonatomic, copy) OLRichInboxBannerCardViewDisplayBlock bannerDidDisplay;

/**
* Required: This must be called from the view controller whenever the banner appears
*/
-(void)bannerWillAppear;

/**
* Required: This must be called from the view controller whenever the banner disappears
*/
-(void)bannerWillDisappear;


@end
