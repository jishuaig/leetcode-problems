package 树;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的真二叉树894 {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int left = 1, right = n - left - 1; left < n; left += 2, right--) {
            List<TreeNode> leftResult = allPossibleFBT(left);
            List<TreeNode> rightResult = allPossibleFBT(right);
            for (TreeNode leftNode : leftResult) {
                for (TreeNode rightNode : rightResult) {
                    result.add(new TreeNode(0, leftNode, rightNode));
                }
            }
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        if (root.left == null) {
            root.left = new TreeNode(root.val + 1);
        }
    }
}
