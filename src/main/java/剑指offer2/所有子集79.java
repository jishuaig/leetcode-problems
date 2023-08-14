package 剑指offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 所有子集79 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            help(nums, i, ans, list);
        }
        return ans;
    }

    public void help(int[] nums, int i, List<List<Integer>> ans, List<Integer> list) {
        list.add(nums[i]);
        ans.add(new ArrayList<>(list));
        for (int j = i + 1; j < nums.length; j++) {
            help(nums, j, ans, list);
        }
        list.remove(Integer.valueOf(nums[i]));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new 所有子集79().subsets(nums));
    }

}
