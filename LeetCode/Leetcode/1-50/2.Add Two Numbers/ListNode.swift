//
//  ListNode.swift
//  Leetcode
//
//  Created by WengHengcong on 2018/1/17.
//  Copyright © 2018年 LuCi. All rights reserved.
//

import UIKit

/// 链表
public class ListNode {
    public var val: Int
    public var next: ListNode?
    public init(_ val: Int) {
        self.val = val
        self.next = nil
    }
}
