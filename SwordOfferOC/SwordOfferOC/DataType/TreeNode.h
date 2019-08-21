//
//  TreeNode.h
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface TreeNode : NSObject

@property (nonatomic, assign) NSNumber *val;
@property (nonatomic, strong) TreeNode *left;
@property (nonatomic, strong) TreeNode *right;

@end

NS_ASSUME_NONNULL_END
