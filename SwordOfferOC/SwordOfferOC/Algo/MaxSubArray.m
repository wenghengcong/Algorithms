//
//  MaxSubArray.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "MaxSubArray.h"

@implementation MaxSubArray


/**
 最大子数组
 */
+ (int)maxSubArray:(int [])array length:(int)length
{
    if (array == nil || length == 0){
        return 0;
    }
    
    //max记录全局最大值，sum记录区间和，如果当前sum>0，那么可以继续和后面的数求和，否则就从0开始
    int max = 0, sum = 0;
    for (int i = 0; i < length; i++) {
        sum += array[i];
        max = MAX(max, sum);
        sum = MAX(sum, 0);
    }
    
    return max;
}

@end
