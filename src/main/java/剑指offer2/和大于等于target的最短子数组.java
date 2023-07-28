package 剑指offer2;

import java.util.*;

public class 和大于等于target的最短子数组 {

    public int minSubArrayLen(int target, int[] nums) {

        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = (i == 0 ? 0 : sums[i - 1]) + nums[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum == target) {
                    min = Math.min(min, j - i + 1);
                    break;
                } else if (sum > target) {
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new 和大于等于target的最短子数组().minSubArrayLen2(11, nums));
    }

}
