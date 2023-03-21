package 树;

import java.util.HashMap;
import java.util.Map;

public class 从中序与后序遍历序列构造二叉树106 {

    private Map<Integer, Integer> map;
    private int rootIdx;
    private int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIdx = postorder.length - 1;
        in = inorder;
        post = postorder;
        map = new HashMap<>();
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }
        return help(0, inorder.length - 1);
    }

    private TreeNode help(int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(post[rootIdx]); // 找到根节点
        int index = map.get(post[rootIdx]);
        rootIdx--;
        root.right = help(index + 1, end);
        root.left = help(start, index - 1);
        return root;
    }
}
