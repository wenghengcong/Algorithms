//
//  RemoveListNode.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "RemoveListNode.h"
#import "ListNode.h"

@implementation RemoveListNode

- (void)removeNode:(ListNode *)node
{
    if (node == nil) {
        return;
    }
    
    ListNode *nextNode = node.next;
    node.val = nextNode.val;
    node.next = nextNode.next;
}

@end
