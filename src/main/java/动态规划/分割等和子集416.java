package 动态规划;

import java.util.Arrays;

/**
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class 分割等和子集416 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if (target * 2 != sum) return false;
        boolean[][] dp = new boolean[len + 1][target + 1]; // dp[i][j] 在[0,i]这个区间的数，从他们当中是否可以取一些数，使得和正好为j
        dp[0][0] = true; // 第0行，表示不放任何数
        for (int i = 1; i <= len; i++) {
            int t = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                boolean n = dp[i][j] = dp[i - 1][j];
                boolean y = j >= t ? dp[i - 1][j - t] : false;
                dp[i][j] = n || y;
            }
        }
        return dp[len][target];
    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            int t = nums[i - 1];
            for (int j = target; j >= 0; j--) {
                boolean n = dp[j];
                boolean y = j >= t ? dp[j - t] : false;
                dp[j] = n || y;
            }
        }
        return dp[target];
    }

}
