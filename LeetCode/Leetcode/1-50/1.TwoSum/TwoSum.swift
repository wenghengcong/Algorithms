//
//  twoSum.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/10.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

/// problem: https://leetcode.com/problems/two-sum/description/
/// solution: https://leetcode.com/problems/two-sum/solution/
class TwoSum {
    
   static func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        if nums.count == 0 {
            return [0, 0]
        }
        for current in 0..<nums.count {
            let next = current+1
            for next in next..<nums.count {
                let sum = nums[current] + nums[next]
                if sum == target {
                    return [current, next]
                }
            }
        }
        return [0, 0]
    }
    
}
