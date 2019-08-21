//
//  BinarySearch.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "BinarySearch.h"

@implementation BinarySearch


+ (int)search:(int)key array:(int[])array lower:(int)lower high:(int)high
{
    int mid = lower + (high-lower)/2;
    if (key < array[mid]) {
        int newHigh = mid - 1;
        return [self search:key array:array lower:lower high:newHigh];
    } else if(key > array[mid]) {
        int newLower = mid + 1;
        return [self search:key array:array lower:newLower high:high];
    } else {
        return mid;
    }
    
    return -1;
}

+ (int)search2:(int)key array:(int[])array lower:(int)lower high:(int)high
{
    while (lower <= high) {
        int mid = lower + (high - lower)/2;
        if (key < array[mid]) {
            high = mid - 1;
        } else if(key > array[mid]) {
            lower = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}


@end
