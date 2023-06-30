package 动态规划;

/**
 * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/
 */
public class 掷骰子等于目标和的方法数1155 {

    int mod = 1000000000 + 7;

    // 利用分组背包思想来解决
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1]; // 前i个色子和为target的方案数
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[i][j] += dp[i - 1][j - l];
                        dp[i][j] = dp[i][j] % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        System.out.println(new 掷骰子等于目标和的方法数1155().numRollsToTarget(2, 6, 7));
    }


}
