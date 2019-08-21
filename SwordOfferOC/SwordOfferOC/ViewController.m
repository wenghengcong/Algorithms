//
//  ViewController.m
//  SwordOfferOC
//
//  Created by Hunt on 2019/8/4.
//  Copyright © 2019 WengHengcong. All rights reserved.
//

#import "ViewController.h"
#import "Fib.h"
#import "BinarySearch.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    int n = [Fib fib:1];
    NSLog(@"%d", n);
    
    
    int array[10] = {1, 3, 5, 8, 10, 12, 15};
    int find = [BinarySearch search:10 array:array lower:0 high:9];
    NSLog(@"%d", find);
}


@end
