//
//  LongestPalindromicSubstring.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/23.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

/// problem: https://leetcode.com/problems/longest-palindromic-substring/description/
/// solution: https://leetcode.com/problems/longest-palindromic-substring/solution/
class LongestPalindromicSubstring: NSObject {
    
    /// 寻找回文字符串
    /// 中心扩展：：O(n2)
    /// 比动态规划方法更优
    static func longestPalindromeByCenterExpend(_ s: String) -> String {
        let length = s.count
        if length == 0 || length == 1 {
            return s
        }
        let chars = Array(s)

        var begin = 0, maxLen = 1
        for i in 0..<length {
            var j = i, k = i
            while k < length-1 && chars[k] == chars[k+1] {
                //有相同字母的情况： "aaa"
                k = k + 1
            }
            while j > 0 && k < length-1 && chars[j-1] == chars[k+1] {
                //不同的字母的情况： "bab"
                k = k + 1
                j = j - 1
            }
            
            let palidLength = k-j+1
            if palidLength > maxLen {
                maxLen = palidLength
                begin = j
            }
        }
        let starIndex = s.index(s.startIndex, offsetBy: begin)
        let endIndex = s.index(starIndex, offsetBy: maxLen)
        return String(s[starIndex..<endIndex])
    }
    
    /// 寻找回文字符串
    /// 动态规划：O(n2)
    static func longestPalindromeOptimize(_ s: String) -> String {
        //假如字符串是0位，或者1位，直接返回
        let length = s.count
        if length == 0 || length == 1 {
            return s
        }
        let chars = Array(s)
        //创建二维数组
        var begin = 0, maxLen = 1
        //dpTable[i][j] 表示子串s[i…j]是否是回文，我们这样定义实际上变相知道了当前回文子串的长度，以及在原字符串中的位置。
        var dpTable: [[Bool]] = Array(repeatElement(Array(repeatElement(false, count: length)), count: length))
        
        //针对以上dpTable，对整个数组进行赋值
        //首先，对1个字符，即s[i][i]这样的字符串子串都是回文字符串，所以，赋值true
        for i in 0..<length {
            dpTable[i][i] = true
        }
        //对于两个字符的，s[i][i+1]，如果相等，就是回文字符串
        for i in 0..<length-1 {
            if chars[i] == chars[i+1] {
                dpTable[i][i+1] = true
                begin = i
                maxLen = 2
            }
        }
        //对于三个字符长度以上的字符串，才符合动态规划的要求
        if length >= 3 {
            for len in 3...length {
                for i in 0..<length-len+1 {
                    let j = i+len-1
                    if chars[i] == chars[j] && dpTable[i+1][j-1] {
                        dpTable[i][j] = true
                        begin = i
                        maxLen = len
                    }
                }
            }
        }

        let starIndex = s.index(s.startIndex, offsetBy: begin)
        let endIndex = s.index(starIndex, offsetBy: maxLen)
        return String(s[starIndex..<endIndex])
    }
    
    
    /// 寻找回文字符串
    /// 时间复杂度不过关，o(n3)
    static func longestPalindrome(_ s: String) -> String {
        if s.count == 1 {
            return s
        }
        var longestString = ""
        let characters = Array(s)
        
        for i in 0..<characters.count {
            for j in i..<characters.count {
                let sub = String(characters[i...j])
                if self.matchPalindrome(sub) && longestString.count <= sub.count {
                    longestString = sub
                }
            }
        }
        return longestString
    }
    
    /// 是否是回文字符串
    static func matchPalindrome(_ s: String) -> Bool {
        if s.count == 0  {
            return false
        }
        let characters = Array(s)
        let length = characters.count
        let middle: Int = length/2

        for i in 0..<middle {
            let j = length-i-1
            if characters[i] != characters[j] {
                return false
            }
        }
        return true
    }
    
}
