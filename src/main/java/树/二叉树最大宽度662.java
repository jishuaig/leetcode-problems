package 树;

import base.Pair;
import base.TreeNode;

import java.util.LinkedList;

public class 二叉树最大宽度662 {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int ans = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            LinkedList<Pair<TreeNode, Integer>> temp = new LinkedList<>();
            for (Pair<TreeNode, Integer> pair : queue) {
                TreeNode node = pair.left;
                int index = pair.right;
                if (node.left != null) {
                    temp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    temp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            ans = Math.max(ans, queue.get(queue.size() - 1).right - queue.get(0).right + 1);
            queue = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new 二叉树最大宽度662().widthOfBinaryTree(root));
    }

}
