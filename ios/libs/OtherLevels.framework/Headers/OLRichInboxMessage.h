//
//  OtherLevelsRichInboxMessage.h
//  OtherLevels
//
//  Copyright 2013-2015 OtherLevels. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OLRichInboxMessage : NSObject

@property (nonatomic, assign) int notifID;
@property (nonatomic, strong) NSString *subject;
@property (nonatomic, strong) NSString *cardImage;
@property (nonatomic, strong) NSString *cardBackgroundColor;
@property (nonatomic, strong) NSString *cardForegroundColor;
@property (nonatomic, strong) NSString *content;
@property (nonatomic, strong) NSString *label;
@property (nonatomic, strong) NSString *url;
@property (nonatomic, strong) NSString *phash;
@property (nonatomic, assign) int read;
@property (nonatomic, assign) NSTimeInterval created;
@property (nonatomic, assign) NSTimeInterval end;


@end
