package 树;

import base.TreeNode;

public class 将有序数组转换为二叉搜索树108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return help(nums, 0, nums.length - 1);
    }

    public TreeNode help(int[] nums, int start, int end) {
        if (start < end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);
        return root;
    }

}
