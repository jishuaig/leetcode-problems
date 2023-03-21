package 动态规划.背包问题;

public class 背包01 {

    // v体积 ， w价值， N物品数量，C背包容量
    public int maxValue(int[] v, int[] w, int N, int C) {
        int[][] dp = new int[N][C + 1]; // 使用当前物品i背包容量不超过C的最大价值
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= w[i] ? w[i] : 0;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                int n = dp[i - 1][j];
                int y = j >= v[i] ? dp[i - 1][j - v[i]] + w[i] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N - 1][C];
    }

    public int maxValue2(int[] v, int[] w, int N, int C) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < v.length; i++) {
            for (int j = C; j >= v[i]; j--) {
                int n = dp[j];
                int y = dp[v[i] - j] + w[i];
                dp[j] = Math.max(n, y);
            }
        }
        return dp[C];
    }

}
