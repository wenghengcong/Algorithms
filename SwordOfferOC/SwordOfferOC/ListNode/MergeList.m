//
//  MergeList.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "MergeList.h"
#import "ListNode.h"

@implementation MergeList

+ (ListNode *)mergeList:(ListNode *)listA listB:(ListNode *)listB
{
    ListNode *newList = [ListNode new];
    ListNode *tmp = newList;
    while (listA != nil && listB != nil) {
        if (listA.val < listB.val) {
            tmp.next = listA;
            listA = listA.next;
        } else {
            tmp.next = listB;
            listB = listB.next;
        }
    }
    
    if (listA != nil) {
        tmp.next = listA;
    } else {
        tmp.next = listB;
    }
    
    return newList;
}

@end
