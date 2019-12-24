package 树;


import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树105 {

    private Map<Integer, Integer> map = new HashMap<>();
    private int rootIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }
        return help(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode help(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[rootIdx]); // 找到根节点
        int index = map.get(preorder[rootIdx]);
        rootIdx ++;
        root.left = help(preorder, inorder, start, index - 1);
        root.right = help(preorder, inorder, index + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }

}
