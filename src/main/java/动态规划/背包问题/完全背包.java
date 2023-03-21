package 动态规划.背包问题;

public class 完全背包 {

    // v体积 ， w价值， N物品数量，C背包容量
    public int maxValue(int N, int C, int[] v, int[] w) {

        int[][] dp = new int[N][C + 1];

        // 放第一个物品到背包
        for (int j = 0; j <= C; j++) {
            int maxK = j / v[0];
            dp[0][j] = maxK * w[0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // 选择0次，第i件物品
                int n = dp[i - 1][j];
                // 选择1次或者多次
                int y = 0;
                for (int k = 1; ; k++) {
                    if (v[i] * k > j) {
                        break;
                    }
                    y = Math.max(y, dp[i - 1][j - v[i] * k] + w[i] * k);
                }
                dp[i][j] = Math.max(y, n);
            }
        }
        return dp[N - 1][C];
    }

}
