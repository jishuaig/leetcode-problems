package 链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode of(int... a) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i : a) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        return sb.toString();
    }
}
