//
//  IntersectionListNode.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "IntersectionListNode.h"
#import "ListNode.h"

@implementation IntersectionListNode

+ (ListNode *)findIntersectionListNode:(ListNode *)listA listB:(ListNode *)listB
{
    if (listA == nil || listB == nil) {
        return nil;
    }
    int a_len = 0;
    int b_len = 0;
    
    ListNode *tmpA = listA;
    ListNode *tmpB = listB;
    while (tmpA != nil) {
        tmpA = tmpA.next;
        a_len++;
    }
    
    while (tmpB != nil) {
        tmpB = tmpB.next;
        b_len++;
    }
    
    tmpA = listA;
    tmpB = listB;
    if (a_len > b_len) {
        int margin = a_len - b_len;
        for (int i = 0; i < margin; i++) {
            tmpA = tmpA.next;
        }
    }
    
    if (b_len > a_len) {
        int margin = b_len - a_len ;
        for (int i = 0; i < margin; i++) {
            tmpB = tmpB.next;
        }
    }
    
    while (tmpA != tmpB) {
        tmpA = tmpA.next;
        tmpB = tmpB.next;
    }
    
    return tmpA;
}

@end
