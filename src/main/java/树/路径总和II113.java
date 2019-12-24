package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class 路径总和II113 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        help(root, sum, 0);
        return result;
    }

    public void help(TreeNode node, int sum, int acc) {
        acc += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == acc) {
                result.add(new ArrayList<>(list));
            }
        } else {
            if (node.left != null) {
                help(node.left, sum, acc);
            }
            if (node.right != null) {
                help(node.left, sum, acc);
            }
            list.remove(list.size() - 1);
        }
    }
}
