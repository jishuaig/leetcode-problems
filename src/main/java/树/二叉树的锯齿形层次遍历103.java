package 树;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 思路：每一层的节点存放在栈（s1左->右, s2右->左）中，
 */
public class 二叉树的锯齿形层次遍历103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    TreeNode cur = s1.pop();
                    res.add(cur.val);
                    if (cur.left != null) s2.push(cur.left);
                    if (cur.right != null) s2.push(cur.right);
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode cur = s2.pop();
                    res.add(cur.val);
                    if (cur.right != null) s1.push(cur.right);
                    if (cur.left != null) s1.push(cur.left);
                }
            }
            result.add(res);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 1, list);
        return list;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) return;
        if (ans.size() < level) {
            ans.add(new ArrayList<>());
        }
        if (level % 2 == 1) {
            ans.get(level).add(root.val);
        } else {
            ans.get(level).add(0, root.val);
        }
        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }


}
