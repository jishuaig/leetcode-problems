package 树;

import base.TreeNode;

public class 合并二叉树617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode node = new TreeNode(0);
        node.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        node.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        node.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return node;
    }

    public static void main(String[] args) {

    }

}
