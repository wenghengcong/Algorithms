package sword.chap3;

import foundation.ListNode;

/**
 * @author wenghengcong
 * @className: DeleteNthFromEnd
 * @desc:
 * @date 2019-07-0315:11
 */
public class DeleteNthFromEnd {

    /**
     * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。O(n)时间复杂度
     * 题目： https://www.lintcode.com/problem/remove-nth-node-from-end-of-list/description?_from=ladder&&fromId=6
     * 题解：https://www.jiuzhang.com/solution/remove-nth-node-from-end-of-list/
     * 解法：先让快指针走n步，然后快慢一起走，走到头的时候慢指针指向的点删掉。
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        // 创建一个新节点，使得preDelete在两个指针移动时，最后落在需要删除节点的前一个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;

        // 让head指针作为快指针，先走n步
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        // 将head与preDelete同步前移
        // head最后移动到尾节点的下一个节点null，而preDelete刚好会移动到需要删除节点的前一个节点
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
