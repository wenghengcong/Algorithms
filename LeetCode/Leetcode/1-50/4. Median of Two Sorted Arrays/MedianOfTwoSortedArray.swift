//
//  MedianOfTwoSortedArray.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/21.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

/// problem: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
/// solution: https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
class MedianOfTwoSortedArray: NSObject {
    
    /// 寻找中位数
    static func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
        var A: [Int] = nums1
        var B: [Int] = nums2
        
        var m = A.count
        var n = B.count

        if (m > n) { // to ensure m<=n
            let temp: [Int] = A
            A = B
            B = temp
            let tmp = m
            m = n
            n = tmp
        }
        var iMin = 0, iMax = m, halfLen = (m + n + 1) / 2
        while (iMin <= iMax) {
            let i: Int = Int((iMin + iMax) / 2)
            let j: Int = halfLen - i
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                var maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1]
                } else if (j == 0) {
                    maxLeft = A[i-1]
                } else {
                    maxLeft = max(A[i-1], B[j-1])
                }
                if ( (m + n) % 2 == 1 ) {
                    return Double(maxLeft)
                }
                
                var minRight = 0;
                if (i == m) {
                    minRight = B[j]
                }else if (j == n) {
                    minRight = A[i]
                } else {
                    minRight = min(B[j], A[i])
                }
                
                return (Double(maxLeft) + Double(minRight)) / 2.0
            }
        }
        return 0.0
    }
}
