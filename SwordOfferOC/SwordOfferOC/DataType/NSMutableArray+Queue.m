//
//  NSMutableArray+Queue.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "NSMutableArray+Queue.h"

@implementation NSMutableArray (Queue)

- (id) dequeue {
    // if ([self count] == 0) return nil; // to avoid raising exception (Quinn)
    id headObject = [self objectAtIndex:0];
    if (headObject != nil) {
        [self removeObjectAtIndex:0];
    }
    return headObject;
}

// Add to the tail of the queue (no one likes it when people cut in line!)
- (void) enqueue:(id)anObject {
    [self addObject:anObject];
    //this method automatically adds to the end of the array
}

- (BOOL)isEmpty
{
    return [self count] == 0;
}

@end
