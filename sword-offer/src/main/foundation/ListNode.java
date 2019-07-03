package foundation;

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
