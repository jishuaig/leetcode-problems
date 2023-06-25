package 树;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 路径总和113 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        sum -= root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0)
                ans.add(new ArrayList<>(temp)); // 需要拷贝一份
        }
        if (root.left != null)
            pathSum(root.left, sum);
        if (root.right != null)
            pathSum(root.right, sum);
        temp.remove(temp.size() - 1);
        return ans;
    }
}
