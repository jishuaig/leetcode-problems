package 动态规划.背包问题;


public class 多重背包 {

    private static int[] P = {0, 2, 3, 4}; // 价值
    private static int[] V = {0, 3, 4, 5}; // 体积
    private static int[] M = {0, 4, 3, 2}; // 数量
    private static int T = 15; // 背包容量

    private Integer[][] results = new Integer[P.length + 1][T + 1];

    private int[][] dp = new int[P.length + 1][T + 1];

    public void solve() {
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j <= T; j++) {
                for (int k = 0; k <= M[i] && k * V[i] <= j; k++) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j - k * V[i]] + k * P[i]);
                }
            }
        }
        System.out.println("最大价值为：" + dp[P.length][T]);
    }
}