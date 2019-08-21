//
//  Fib.h
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN



@interface Fib : NSObject

/**
 斐波那契数列
 0, 1, 1, 2, 3, 5......
 传入参数为n，为第n个数，如n = 1,结果为0
 */
+(int)fib:(int)n;

@end

NS_ASSUME_NONNULL_END
