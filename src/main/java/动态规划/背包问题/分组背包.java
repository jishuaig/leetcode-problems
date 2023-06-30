package 动态规划.背包问题;

public class 分组背包 {

    /**
     * 给定N个物品组，和容量为C的背包。
     * 第i个物品组共有s[i]件物品，其中第i组的第j件物品的成本为v[i][j]，价值为w[i][j]。
     * 每组有若干个物品，同一组内的物品最多只能选一个。
     * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     */
    public int maxValue(int N, int C, int[] S, int[][] v, int[][] w) {

        int[][] dp = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            int[] vi = v[i - 1];
            int[] wi = w[i - 1];
            int si = S[i - 1];
            for (int j = 1; j <= C; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < si; k++) {
                    if (j >= vi[k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - vi[k]] + wi[k]);
                    }
                }
            }
        }
        return dp[N][C];
    }

}
