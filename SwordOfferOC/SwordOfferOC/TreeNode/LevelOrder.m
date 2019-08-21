//
//  LevelOrder.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "LevelOrder.h"
#import "TreeNode.h"
#import "NSMutableArray+Queue.h"


@implementation LevelOrder

+(NSArray *)levelOrder:(TreeNode *)root
{
    NSMutableArray *resutlt = [NSMutableArray array];
    if (root == nil) {
        return resutlt;
    }
    
    NSMutableArray *queue = [NSMutableArray array];
    [queue enqueue:root];
    
    while (![queue isEmpty]) {
        NSUInteger levelSize = queue.count;
        NSMutableArray *currentLevel = [NSMutableArray array];
        for (int i = 0; i < levelSize; i++) {
            // 当前层的节点
            TreeNode *cur = [queue dequeue];
            [currentLevel addObject:cur.val];
            
            if (cur.left != nil) {
                [queue enqueue:cur.left];
            }
            if (cur.right != nil) {
                [queue enqueue:cur.right];
            }
            
            [resutlt addObjectsFromArray:currentLevel];
        }
    }
    
    return resutlt;
}

@end
