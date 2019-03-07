package chap2;

import java.awt.*;

public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    /*
    * 实现一
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
        if (head == null) return null;
        ListNode pre = head;    //上一个节点
        ListNode cur = head.next;   //当前节点
        ListNode temp = null;       //暂时缓存下一个节点
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;     //进行翻转
            //将pre,cur重新置换成下一个
            pre = cur;
            cur = temp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;
        return pre;
    }

    /*
    * 递归实现
    * 递归到最后，先将最后一个节点转换。
    *
    * */
    public static ListNode reverseIteration(ListNode head) {
        // node看作是前一结点，head.getNext()是当前结点，cur是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        ListNode cur = reverseIteration(head.next);//先反转后续节点head.getNext()
        head.next.next = head;//将当前结点的指针域指向前一结点
        head.next = null;//前一结点的指针域令为null
        return cur;//反转后新链表的头结点
    }

    @Override
    public String toString() {
        String listString = "";
        ListNode head = this;
        while (head != null) {
            listString = listString + String.valueOf(head.val) + "->";
            head = head.next;
        }
        return listString;
    }
}
