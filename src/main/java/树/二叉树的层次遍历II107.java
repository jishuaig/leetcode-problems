package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的层次遍历II107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(0, list);
        }
        return result;
    }

}
