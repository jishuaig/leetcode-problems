package 树;


import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层次遍历102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> l1 = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode r = q.poll();
                l1.add(r.val);
                if (r.left != null) q.offer(r.left);
                if (r.right != null) q.offer(r.right);
            }
            result.add(l1);
        }
        return result;
    }

    public static void main(String[] args) {
        二叉树的层次遍历102 s = new 二叉树的层次遍历102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.levelOrder(root));
    }

}
