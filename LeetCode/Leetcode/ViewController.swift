//
//  ViewController.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/10.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
//        testTwoSum()
    }
    
    @IBAction func testAction(_ sender: Any) {
        testPalindromeNumber()
    }
    //1.
    func testTwoSum() {
        let nums = [2, 7, 11, 15]
        let target = 22
        let indices = TwoSum.twoSum(nums, target)
        print("towsum test \(indices)")
    }
    //2.
    func testAddTwoNumbers() {
        
        let list1 = [2,4,3]
        let list2 = [5,6,4]
        
//        let list1 = [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
//        let list2 = [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
        
        let node1 = AddTwoNumbers.makeNodeList(numbers: list1)
        let node2 = AddTwoNumbers.makeNodeList(numbers: list2)
        
        AddTwoNumbers.printListNode(node1)
        AddTwoNumbers.printListNode(node2)
        
        let list3 = AddTwoNumbers.addTwoBigNumbersOptimize(node1, node2)
        AddTwoNumbers.printListNode(list3)
    }
    //3.
    func testLongestNoRepeatChars() {
        let test1 = SubstringNoRepeatChars.lengthOfLongestSubstringOptimize("abcabcdbb")
        let test2 = SubstringNoRepeatChars.lengthOfLongestSubstringOptimize("c")
        let test3 = SubstringNoRepeatChars.lengthOfLongestSubstringOptimize("pwwkew")
        print("\(test1),\(test2),\(test3)")
    }
    //4.
    func testMediaOfTwoSortedArray() {
        let num1 = [1, 3, 5, 9, 18]
        let num2 = [2, 4, 8, 13, 20]
        let media = MedianOfTwoSortedArray.findMedianSortedArrays(num1, num2)
        print("meida \(media)")
    }
    
    //5
    func testLongestPalindromicSubstring() {
        let s = "abcb"
        let s1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
        let matches = LongestPalindromicSubstring.longestPalindromeByCenterExpend(s)
        let find = LongestPalindromicSubstring.longestPalindrome(s)
        print("find longest palindromic substring: \(find)")
    }
    
    //6
    func testPalindromeNumber() {
        let x = 121
        let isPalindrome = PalindromeNumber.isPalindrome(x)
        print("is palindrome \(isPalindrome)")
    }
    
}

