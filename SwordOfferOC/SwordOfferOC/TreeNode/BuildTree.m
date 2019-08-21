//
//  BuildTree.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "BuildTree.h"
#import "TreeNode.h"

@implementation BuildTree

+ (TreeNode *)buildTree:(NSArray *)preOrder inOrder:(NSArray *)inOrder
{
    if (preOrder == nil || inOrder == nil
        || [preOrder count] == 0
        || [inOrder count] == 0) {
        return nil;
    }
    
    return [self iterateBuildTree:preOrder preStart:0 preEnd:preOrder.count inOrder:inOrder inStart:0 inEnd:inOrder.count];
}

+ (NSInteger)findRootPosition:(NSNumber *)root
                       inOrder:(NSArray *)inOrder
                       inStart:(NSInteger)inStart
                         inEnd:(NSInteger)inEnd
{
    for (NSInteger i = inStart; i <= inEnd; i++) {
        NSNumber *cur = inOrder[i];
        if (cur.integerValue == root.integerValue) {
            return i;
        }
    }
    return -1;
}

+ (TreeNode *)iterateBuildTree:(NSArray *)preOrder
                      preStart:(NSInteger)preStart
                        preEnd:(NSInteger)preEnd
                        inOrder:(NSArray *)inOrder
                       inStart:(NSInteger)inStart
                         inEnd:(NSInteger)inEnd
{
    if (inStart > inEnd) {
        return nil;
    }
    
    TreeNode *root = [[TreeNode alloc] init];
    root.val = preOrder[preStart];
    
    NSInteger pos = [self findRootPosition:root.val inOrder:inOrder inStart:inStart inEnd:inEnd];
    NSInteger leftSize = pos-inStart;
    NSInteger rightSize = inEnd-pos;
    root.left = [self iterateBuildTree:preOrder preStart:preStart+1 preEnd:preStart+leftSize inOrder:inOrder inStart:inStart inEnd:pos-1];
    root.right = [self iterateBuildTree:preOrder preStart:preEnd-rightSize+1 preEnd:preEnd inOrder:inOrder inStart:pos+1 inEnd:inEnd];
    return root;
}


@end
