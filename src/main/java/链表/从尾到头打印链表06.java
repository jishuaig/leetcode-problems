package 链表;

import java.util.ArrayList;
import java.util.List;

public class 从尾到头打印链表06 {

    private static List<Integer> result = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        traverse(head);
        int[] arry = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arry[i] = result.get(i);
        }
        return arry;
    }

    public void traverse(ListNode node) {
        if (node.next == null) return;
        traverse(node.next);
        result.add(node.val);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        System.out.println(new 从尾到头打印链表06().reversePrint(l1));
    }

}
