//
//  SubstringNoRepeatChars.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/18.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit


/// problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
/// solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/

class SubstringNoRepeatChars {
    static func lengthOfLongestSubstringOptimize(_ s: String) -> Int {
        let n = s.count
        var set: Set<Character> = Set()
        var ans = 0, i = 0, j = 0
        
        let characters = Array(s)
        while i < n && j < n {
            let charAtJ = characters[j]
            if !set.contains(charAtJ) {
                set.insert(charAtJ)
                j = j + 1
                ans = max(ans, j-i)
            } else {
                let charAtI = characters[i]
                set.remove(charAtI)
                i = i + 1
            }
        }
        
        return ans
    }
    
    /// 时间复杂度不过关
    static func lengthOfLongestSubstring(_ s: String) -> Int {
        if s.count == 0 || s.count == 1 {
            return s.count
        }
        let characters = Array(s)
        var currentMaxString = ""
        var tmp: String = ""
        for i in 0..<characters.count {
            let next = i+1
            for j in next..<characters.count {
                let currentChar = characters[j]
                let tmpArr = characters[i..<j]
                tmp = String(tmpArr)
                if tmp.contains(currentChar) {
                    if tmp.count >= currentMaxString.count {
                        currentMaxString = tmp
                    }
                    break
                } else {
                    let nextMax = characters[i...j]
                    tmp = String(nextMax)
                    if tmp.count >= currentMaxString.count {
                        currentMaxString = tmp
                    }
                }
            }
        }
        return currentMaxString.count
    }
    
}
