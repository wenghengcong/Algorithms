//
//  ReverseList.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "ReverseList.h"

@implementation ReverseList

- (ListNode *)reverstList:(ListNode *)head
{
    ListNode *p = head;
    ListNode *newH = [[ListNode alloc] init];
    newH.next = nil;
    
    while (p != nil) {
        ListNode *temp = p.next;
        
        p.next = newH;
        newH = p;
        p = temp;
    }
    return newH;
}

@end
