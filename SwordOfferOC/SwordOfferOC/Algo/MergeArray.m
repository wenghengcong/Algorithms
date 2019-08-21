//
//  MergeArray.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "MergeArray.h"

@implementation MergeArray

+ (void)mergeArray:(int[])A  aLength:(int)aLen b:(int[])B bLength:(int)bLen result:(int[])result
{
    int i = 0;
    int j = 0;
    int p = 0;
    
    while (i < aLen && j < bLen) {
        if (A[i] < B[j]) {
            result[p++] = A[i++];
        } else {
            result[p++] = B[j++];
        }
    }
    
    while (i < aLen) {
        result[p++] = A[i++];
    }
    
    while (j < bLen) {
        result[p++] = B[j++];
    }
}

@end

