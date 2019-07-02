package sword.chap2;

/**
 * @author wenghengcong
 * */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

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

    /**
     * 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在 O(1) 时间复杂度删除该链表节点。
     * 题目： https://www.lintcode.com/problem/delete-node-in-a-linked-list/description?_from=ladder&&fromId=6
     * 题解：https://www.jiuzhang.com/solution/delete-node-in-a-linked-list/
     * */
    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }


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

    /**
     * 将两个排序链表合并为一个新的排序链表
     * 题目：https://www.lintcode.com/problem/merge-two-sorted-lists/description?_from=ladder&&fromId=6
     * 题解：https://www.jiuzhang.com/solution/merge-two-sorted-lists/
     * 与合并数组一个方法，两个指针往后走。
     * */
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


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            builder.append(head.val);
            builder.append("->");
            head = head.next;
        }
        return builder.toString();
    }
}
