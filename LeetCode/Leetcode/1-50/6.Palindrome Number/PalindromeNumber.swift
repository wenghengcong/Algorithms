//
//  PalindromeNumber.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/31.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

class PalindromeNumber: NSObject {
    
    //分析：回文数
    //回文数是两边数字一样的，只要判断一个数的倒置数与回文数相等，就是回文数
    //比如121，如果求它的倒置数，就要先获取到个位、十位......
    //获取末位可以通过取余得到，比如121%10，取余得到末位1。
    //每次取余之后，需要将当前数字除以10，获取末数第二位，即(121/10)%10=2,以此类推
    //每次取完之后，需要将末位数又反着来，进行倒置
    //比如，我们取余得到的1，2......进行倒置
    
    static func isPalindrome(_ x: Int) -> Bool {
        if x < 0 {
            return false
        }
        var reverse = 0 , tmp = x
        while tmp > 0 {
            reverse = reverse * 10 + tmp % 10
            tmp = tmp / 10
        }
        if reverse == x {
            return true
        }
        return false
    }
}
