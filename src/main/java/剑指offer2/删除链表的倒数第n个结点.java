package 剑指offer2;

import base.ListNode;

public class 删除链表的倒数第n个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int i = n;
        ListNode fast = head;
        while (i > 0 && fast != null) {
            fast = fast.next;
            i--;
        }
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    // 给removeNthFromEnd生成包含五个元素的测试用例
    public static ListNode generateTestList() {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = generateTestList();
        ListNode result = new 删除链表的倒数第n个结点().removeNthFromEnd(head, 2);
        System.out.println(result);

    }

}
