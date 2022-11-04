package 动态规划;

public class 下降路径最小和931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int dpi = i % 2;
                int dpi_1 = (i - 1) % 2;
                dp[dpi][j] = dp[dpi_1][j] + val;
                if (j - 1 >= 0) dp[dpi][j] = Math.min(dp[dpi_1][j - 1] + val, dp[dpi_1][j]);
                if (j + 1 < n) dp[dpi][j] = Math.min(dp[dpi_1][j + 1] + val, dp[dpi_1][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(dp[(n - 1) % 2][i], ans);
        }
        return ans;
    }

}