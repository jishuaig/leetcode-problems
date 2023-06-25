package 树;

import base.ListNode;
import base.TreeNode;

public class 有序链表转换二叉搜索树109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = getMiddleNode(head);
        TreeNode root = new TreeNode(mid.val);
        if (mid == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        return slow;
    }

    public static void main(String[] args) {
        // [-10, -3, 0, 5, 9]
        ListNode head = ListNode.of(-10, -3, 0, 5, 9);
        new 有序链表转换二叉搜索树109().sortedListToBST(head);
    }

}
