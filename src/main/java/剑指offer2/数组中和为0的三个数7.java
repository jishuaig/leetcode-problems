package 剑指offer2;

import java.util.*;

public class 数组中和为0的三个数7 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                int k = Arrays.binarySearch(nums, j + 1, nums.length, -sum);
                if (k > 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, -1, 0, 1, 2};
        System.out.println(Arrays.binarySearch(nums, 0, 1, -4));
        System.out.println(new 数组中和为0的三个数7().threeSum(nums));
    }

}
