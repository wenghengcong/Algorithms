//
//  NSMutableArray+Queue.h
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface NSMutableArray (Queue)

- (id) dequeue;
- (void) enqueue:(id)obj;

- (BOOL)isEmpty;

@end

NS_ASSUME_NONNULL_END
