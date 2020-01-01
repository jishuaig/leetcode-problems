package 树;

import java.util.ArrayDeque;

public class 序列化和反序列化二叉搜索树449 {

    private StringBuilder str = new StringBuilder("");

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        travel(root);
        return str.substring(0, str.length() - 1);
    }

    private void travel(TreeNode root) {
        if (root == null) return;
        travel(root.left);
        travel(root.right);
        str.append(root.val + " ");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (String s : data.split(" ")) {
            deque.add(Integer.valueOf(s));
        }
        return help(Integer.MIN_VALUE, Integer.MAX_VALUE, deque);
    }

    private TreeNode help(int min, int max, ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) return null;
        int val = deque.getLast();
        if (val < min || val > max) return null;
        deque.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = help(val, max, deque);
        root.left = help(min, val, deque);
        return root;
    }

    public static void main(String[] args) {
        序列化和反序列化二叉搜索树449 test = new 序列化和反序列化二叉搜索树449();
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        test.deserialize(test.serialize(null));
    }


}
