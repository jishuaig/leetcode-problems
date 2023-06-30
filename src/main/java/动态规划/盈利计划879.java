package 动态规划;

public class 盈利计划879 {


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int job = group.length;
        int[][][] dp = new int[job + 1][n + 1][minProfit + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j][0] = 1;
        }
        for (int i = 1; i <= job; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i - 1]) {
                        dp[i][j][k] += dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                        dp[i][j][k] %= 1000000007;
                    }
                }
            }
        }
        return dp[job][n][minProfit];
    }

}
