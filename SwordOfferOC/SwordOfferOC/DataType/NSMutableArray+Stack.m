//
//  NSMutableArray+Stack.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "NSMutableArray+Stack.h"

@implementation NSMutableArray (Stack)

- (id)pop
{
    id headObject = [self objectAtIndex:0];
    if (headObject != nil) {
        [self removeObjectAtIndex:0];
    }
    return headObject;
}

- (id)top
{
    id headObject = [self objectAtIndex:0];
    return headObject;
}

- (void)push:(id)obj
{
    [self insertObject:obj atIndex:0];
}

- (BOOL)isEmpty
{
    return [self count] == 0;
}
@end
