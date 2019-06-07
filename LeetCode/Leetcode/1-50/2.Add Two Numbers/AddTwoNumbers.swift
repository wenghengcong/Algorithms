//
//  AddTwoNumbers.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/17.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit


/// problem: https://leetcode.com/problems/add-two-numbers/description/
/// solution: https://leetcode.com/articles/add-two-numbers/

class AddTwoNumbers {

    /// 优化后的大数相加
    static func addTwoBigNumbersOptimize(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        let dummyHead = ListNode(0)
        var p = l1, q = l2, curr = dummyHead
        var carry = 0
        while p != nil || q != nil {
            let x = p != nil ? p!.val : 0
            let y = q != nil ? q!.val : 0
            let sum = carry + x + y
            carry = sum/10
            curr.next = ListNode(sum%10)
            curr = curr.next!
            if p != nil {
                p = p!.next
            }
            if q != nil {
                q = q!.next
            }
        }
        if carry > 0 {
            curr.next = ListNode(carry)
        }
        return dummyHead.next
    }
    
    static func addTwoBigNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var list1 = l1
        var list2 = l2
        
        var l1ToString: String = ""
        var l2ToString: String = ""
        
        while list1 != nil {
            let current = "\(list1!.val)"
            l1ToString = current+l1ToString
            list1 = list1?.next
        }
        
        while list2 != nil {
            let current = "\(list2!.val)"
            l2ToString = current+l2ToString
            list2 = list2?.next
        }
        
        let maxLength = max(l1ToString.count, l2ToString.count)
        //数位对齐
        let fillZeroNum = abs(l2ToString.count-l1ToString.count)
        if l1ToString.count < l2ToString.count {
            l1ToString = String(repeatElement("0", count: fillZeroNum))+l1ToString
        } else {
            l2ToString = String(repeatElement("0", count: fillZeroNum))+l2ToString
        }
        
        var totalString: String = ""
        var carryBit: Int = 0
        for i in 0..<maxLength {
            let index = l1ToString.index(l1ToString.startIndex, offsetBy: l1ToString.count-i-1)
            let list1Char = String(l1ToString[index])
            let list2Char = String(l2ToString[index])
            if let first = Int(list1Char), let second = Int(list2Char) {
                let sum = first+second+carryBit
                let currentNum = sum%10
                totalString = "\(currentNum)"+totalString
                carryBit = sum/10
            }
        }
        if carryBit > 0 {
            totalString = "\(carryBit)" + totalString
        }
        
        var totalList: ListNode?
        var header: ListNode?
        
        for i in 0..<totalString.count {
            let index = totalString.index(totalString.startIndex, offsetBy: totalString.count-i-1)
            let char = String(totalString[index])
            if let charToInt = Int(char) {
                let node = ListNode.init(charToInt)
                totalList?.next = node
                totalList = node
                if i == 0 {
                    header = node
                }
            }
        }
        return header
    }
    
    /// 两数相加，不适合大数，因为l1Int = Int64(l1ToString)此处转换只能64bit整数值
    static func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
       
        var list1 = l1
        var list2 = l2
        
        var l1ToString: String = ""
        var l2ToString: String = ""
        
        while list1 != nil {
            let current = "\(list1!.val)"
            l1ToString = current+l1ToString
            list1 = list1?.next
        }
        
        while list2 != nil {
            let current = "\(list2!.val)"
            l2ToString = current+l2ToString
            list2 = list2?.next
        }
        
        if let l1Int = Int64(l1ToString), let l2Int = Int64(l2ToString) {
            let totalString = String(l1Int + l2Int)
            if totalString.count == 0 {
                return nil
            }
            var totalList: ListNode?
            var header: ListNode?

            for i in 0..<totalString.count {
                let index = totalString.index(totalString.startIndex, offsetBy: totalString.count-i-1)
                let char = String(totalString[index])
                if let charToInt = Int(char) {
                    let node = ListNode.init(charToInt)
                    totalList?.next = node
                    totalList = node
                    if i == 0 {
                        header = node
                    }
                }
            }
            return header
        }
        return nil
    }
    
    static func makeNodeList(numbers: [Int]) -> ListNode? {
        if numbers.count == 0 {
            return nil
        }
        var list: ListNode?
        var header: ListNode?
        
        for (index,num) in numbers.enumerated() {
            let node = ListNode.init(num)
            list?.next = node
            list = node
            if index == 0 {
                header = node
            }
        }
        return header
    }
    
    static func printListNode(_ listnode: ListNode?) {
        if listnode == nil {
            print("empty list node")
        }
        var printinString = ""
        var listCopy = listnode
        while listCopy != nil {
            printinString = printinString + String(listCopy!.val)
            listCopy = listCopy?.next
            if listCopy != nil {
                printinString = printinString + "->"
            }
        }
        print(printinString)
    }
    
}
