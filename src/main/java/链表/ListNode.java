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
}

