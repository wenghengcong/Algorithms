//
//  MajorityNumber.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "MajorityNumber.h"

@implementation MajorityNumber


/**
 主元素
 使用count计数，相同++不同--。
 主要思想是：因为众数超过总数的一半，所以不会被减到0以下
 */
+ (int)majorityNumber:(int[])nums length:(int)length
{
    if (length == 0) {
        return -1;
    }
    int count = 0;
    int major = nums[0];
    for (int i = 0; i < length; i++) {
        if (major == nums[i]) {
            count++;
        } else {
            count--;
        }
        if (count == 0) {
            major = nums[i];
            count++;
        }
    }
    count = 0;
    for (int i = 0; i < length; i++) {
        if (major == nums[i]) {
            count++;
        }
    }
    if (count > length / 2) {
        return major;
    }
    return -1;
}

@end
