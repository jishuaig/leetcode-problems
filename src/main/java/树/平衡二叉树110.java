package 树;

public class 平衡二叉树110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return help(root) != -1;
    }

    public int help(TreeNode root) {
        if (root == null) return 0;
        int left = help(root.left);
        if (left == -1) return -1;
        int right = help(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
