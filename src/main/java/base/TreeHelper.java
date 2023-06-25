package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeHelper {

    public static TreeNode buildTree(Integer[] tree) {
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer integer : tree) {
            nodes.add(integer == null ? null : new TreeNode(integer));
        }
        for (int i = 0; i < nodes.size() / 2; i++) {
            TreeNode node = nodes.get(i);
            if (node != null) {
                node.left = nodes.get(i * 2 + 1);
                node.right = nodes.get(i * 2 + 2);
            }
        }
        return nodes.get(0);
    }

    public static List<Integer> printTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) queue.push(node.left);
            if (node.right != null) queue.push(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] tree = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = buildTree(tree);
        for (Integer integer : printTree(root)) {
            System.out.println(integer);
        }
    }
}
