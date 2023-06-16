package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            map.put(cur, copyNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node copyCur = map.get(cur);
            if (cur.next != null) {
                copyCur.next = map.get(cur.next);
            }
            if (cur.random != null) {
                copyCur.random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return head == null ? null : map.get(head);
    }

}
