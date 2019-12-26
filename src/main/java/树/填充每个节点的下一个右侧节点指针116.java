package 树;

import java.util.LinkedList;

public class 填充每个节点的下一个右侧节点指针116 {

    // Definition for a Node.
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect1(Node root) {
        if (root == null) return null;
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }
        connect1(root.left);
        connect1(root.right);
        return root;
    }

    public static void main(String[] args) {
    }

}
