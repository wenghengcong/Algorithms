package sword.chap3;

import foundation.ListNode;

/**
 * @author wenghengcong
 * @className: DeleteListNode
 * @desc:
 * @date 2019-07-0315:10
 */

/**
 * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在 O(1) 时间复杂度删除该链表节点。
 * 题目： https://www.lintcode.com/problem/delete-node-in-a-linked-list/description?_from=ladder&&fromId=6
 * 题解：https://www.jiuzhang.com/solution/delete-node-in-a-linked-list/
 * */
public class DeleteListNode {

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
