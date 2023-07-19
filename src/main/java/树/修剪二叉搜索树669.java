package 树;

import base.TreeNode;

public class 修剪二叉搜索树669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val >= low && val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if (val < low) {
            root.right = trimBST(root.right, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
        }
        return root;
    }
}
