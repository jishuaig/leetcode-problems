package 树;

public class 先序遍历构造二叉树1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null) return null;
        return help(preorder, 0, preorder.length - 1);
    }

    public TreeNode help(int[] preorder, int i, int j) {
        if (i > j) return null;
        TreeNode root = new TreeNode(preorder[i]);
        int t = i + 1;
        while (t <= j && preorder[t] < preorder[i]) {
            t++;
        }
        root.left = help(preorder, i + 1, t - 1);
        root.right = help(preorder, t, j);
        return root;
    }

}
