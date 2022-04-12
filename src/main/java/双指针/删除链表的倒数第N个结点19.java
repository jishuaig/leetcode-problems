package 双指针;

import 链表.ListNode;

public class 删除链表的倒数第N个结点19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            head = slow.next;
        } else {
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
        }
        return head;
    }

}
