//
//  OLRichInboxViewConfig.h
//  OtherLevels
//
//  Created by Richard BARGE on 15/04/2015.
//  Copyright (c) 2015 OtherLevels. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OLViewConfig : NSObject

/*
 * Loads the default config file: OLViewConfig
 */
+(void) configure;

/*
 * Loads a none default config file.
 */
+(void) configureWithFileNamed:(NSString*) configFileName;

@end
