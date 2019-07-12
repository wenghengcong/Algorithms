package sword.chap2;

import foundation.ListNode;

/**
 * @author wenghengcong
 * @className: ReverstList
 * @desc:
 * @date 2019-07-0315:08
 */
public class ReverstList {
    /**
     * 翻转链表：实现一
     * 将cur指向当前节点，pre是前一个节点，temp是下一个节点
     * 翻转的过程，就是将cur.next = pre即可
     * 然后，将pre、cur重新置为正确的。
     * pre             cur           temp
     * _________     _________      _________
     * |    |  |     |    |  |      |    |  |
     * |    |..|....>|    |..|.....>|    |..|....>
     * |____|__|     |____|__|      |____|__|
     *
     * */
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        //上一个节点
        ListNode pre = head;
        //当前节点
        ListNode cur = head.next;
        //暂时缓存下一个节点
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            //进行翻转
            cur.next = pre;
            //将pre,cur重新置换成下一个
            pre = cur;
            cur = temp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;
        return pre;
    }

    /**
     * 记住这种解法：头插法，在头结点前创建一个空结点
     * */
    public static ListNode reverse2(ListNode head) {
        //上一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        //暂时缓存下一个节点
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            //进行翻转
            cur.next = pre;
            //将pre,cur重新置换成下一个
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 翻转链表
     * 递归实现
     * 递归到最后，先将最后一个节点转换。
     *
     * */
    public static ListNode reverseIteration(ListNode head) {
        // node看作是前一结点，head.getNext()是当前结点，cur是反转后新链表的头结点
        if (head == null || head.next == null) {
            // 若为空链或者当前结点在尾结点，则直接还回
            return head;
        }
        //先反转后续节点head.getNext()
        ListNode cur = reverseIteration(head.next);
        //将当前结点的指针域指向前一结点
        head.next.next = head;
        //前一结点的指针域令为null
        head.next = null;
        //反转后新链表的头结点
        return cur;
    }

}
