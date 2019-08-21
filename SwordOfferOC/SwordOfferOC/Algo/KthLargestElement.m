//
//  KthLargestElement.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/5.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "KthLargestElement.h"

@implementation KthLargestElement


- (int)kthLargestElementWithK:(int)k nums:(int[])nums length:(int)length
{
    if (nums == nil || length == 0 || k < 1 || k > length){
        return -1;
    }
    return [self partitionWithK:length-k nums:nums start:0 end:length-1];
}

- (int)partitionWithK:(int)k nums:(int[])nums start:(int)start end:(int)end
{
    if (start >= end) {
        return nums[k];
    }
    
    int left = start;
    int right = end;
    int pivot = nums[(start+end)/2];
    
    while (left <= right) {
        while (left <= right && nums[left] < pivot) {
            left++;
        }
        
        while (left < right && nums[right] > pivot) {
            right--;
        }
        
        if (left < right) {
            [self swap:nums i:left j:right];
            left++;
            right--;
        }
    }
    
    if (k <= right) {
        return [self partitionWithK:k nums:nums start:start end:right];
    }
    
    if (k > left) {
        return [self partitionWithK:k nums:nums start:left end:end];
    }
    
    return nums[k];
}

- (void)swap:(int[])nums i:(int)i j:(int)j
{
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

@end
