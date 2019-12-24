package 数据结构;

import java.util.Random;

public class SkipList {

    static class Node {
        private int key, val;
        private Node left, right, up, down;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int level = 1;
    private int size = 0;
    private static Random random = new Random();

    private Node topHead, topTail;

    public SkipList() {
        topHead = new Node(Integer.MIN_VALUE, 0);
        topTail = new Node(Integer.MAX_VALUE, 0);
        topHead.right = topTail;
    }

    public Node find(int key) {
        Node cur = topHead;
        while (true) {
            while (cur.right != null && cur.right.key <= key) {
                cur = cur.right;
            }
            if (cur.down != null) {
                cur = cur.down;
            } else break;
        }
        return cur;
    }

    public int get(int key) {
        Node p = find(key);
        return p.key == key ? p.val : -1;
    }

    public void put(int key, int val) {
        Node p = find(key);
        if (key == p.key) {
            p.val = val;
            return;
        }
        Node q = new Node(key, val);
        insertAfter(p, q);
        int currentLevel = 1;
        while (random.nextDouble() < 0.5) {
            currentLevel++;
            if (currentLevel > level) {
                Node head = new Node(Integer.MIN_VALUE, 0);
                Node tail = new Node(Integer.MAX_VALUE, 0);
                head.right = tail;
                tail.left = head;
                head.down = topHead;
                topHead.up = head;
                tail.down = topTail;
                topTail.up = tail;
                topHead = head;
                topTail = tail;
                level++;
            }
            while (p.up == null) {
                p = p.left;
            }
            p = p.up;
            Node e = new Node(key, val);
            insertAfter(p, e);
            e.down = q;
            q.up = e;
        }

    }

    private void insertAfter(Node p, Node q) {
        q.right = p.right;
        q.left = p;
        p.right.right = q;
        p.right = p;
    }


}
