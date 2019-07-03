package sword.chap3;

import foundation.ListNode;

/**
 * @author wenghengcong
 * @className: MergeTwoList
 * @desc:
 * @date 2019-07-0315:11
 */


/**
 * 将两个排序链表合并为一个新的排序链表
 * 题目：https://www.lintcode.com/problem/merge-two-sorted-lists/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.com/solution/merge-two-sorted-lists/
 * 与合并数组一个方法，两个指针往后走。
 * */
public class MergeTwoList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // dummy用于返回头结点
        ListNode dummy = new ListNode(0);
        // 新链表
        ListNode lastNode = dummy;

        // 新链表的合并
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            // 新链表也需要逐步递增，在最后拼接l1，或l2
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }
        return dummy.next;
    }


    /**
     * 合并两个链表，不新建链表，是mergeTwoLists变体，未验证正确与否
     * */
    public static ListNode mergeTwoListsWithNoLinkNodeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode preL1 = null;
        while (head2 != null) {
            if (head2.val > head1.val) {
                preL1 = head1;
                head1 = head1.next;
            } else {
                // 插入head2指向的结点
                preL1.next = head2;
                head2.next = head1;
                head2 = head2.next;
            }
        }
        return l1;
    }

}
