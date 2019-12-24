package 树;

public class 二叉树中的最大路径和124 {

    private int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return max_sum;
    }

    public int help(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);
        int price = root.val + left + right;
        max_sum = Math.max(max_sum, price);
        return root.val + Math.max(left, right);
    }
}
