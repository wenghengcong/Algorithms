//
//  PreOrder.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "PreOrder.h"
#import "TreeNode.h"
#import "NSMutableArray+Stack.h"

@implementation PreOrder

+(NSMutableArray *)preOrder:(TreeNode *)root
{
    NSMutableArray *stack = [NSMutableArray array];
    NSMutableArray *result = [NSMutableArray array];
    
    if (root == nil) {
        return result;
    }
    
    [stack push:root];
    while (![stack isEmpty]) {
        TreeNode *cur = [stack pop];
        [result addObject:cur.val];
        
        if (cur.right != nil) {
            [stack push:cur.right];
        }
        if (cur.left != nil) {
            [stack push:cur.left];
        }
    }
    
    return result;
}


+ (void)preOrder:(TreeNode *)root result:(NSMutableArray *)result
{
    if (root == nil) {
        return;
    }
    [result addObject:root];
    [self preOrder:root.left result:result];
    [self preOrder:root.right result:result];
}

@end
