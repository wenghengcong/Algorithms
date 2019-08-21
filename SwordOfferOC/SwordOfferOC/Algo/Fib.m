//
//  Fib.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "Fib.h"

@implementation Fib

+ (int)fib:(int)n
{
    int a = 0;
    int b = 1;
    for (int i = 1; i < n; i++) {
        int c = a+b;
        a = b;
        b = c;
    }
    
    return a;
}

@end
