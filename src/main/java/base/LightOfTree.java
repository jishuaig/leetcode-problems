package base;

import java.util.ArrayList;
import java.util.List;

public class LightOfTree {

    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> makeSame(TreeNode t1, TreeNode t2) {
        help(t1, t2, 1, 0);
        for (TreeNode treeNode : result) {
            change(treeNode);
        }
        return result;
    }

    private void help(TreeNode t1, TreeNode t2, int depth, int parentChanges) {
        if (t1 == null || t2 == null) return;
        boolean change = t1.val != t2.val && parentChanges % 2 == 1;
        if (change) result.add(t1);
        help(t1.left, t2.left, depth + 1, parentChanges + (change ? 1 : 0));
        help(t1.right, t2.right, depth + 1, parentChanges + (change ? 1 : 0));
    }

    private void change(TreeNode root) {
        if (root != null) {
            change(root.left);
            root.val = root.val == 1 ? 0 : 1;
            change(root.right);
        }
    }

}
