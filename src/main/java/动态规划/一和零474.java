package 动态规划;

public class 一和零474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length; i++) {
            int[] count = getZeroCount(strs[i]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    int zeros = count[0];
                    int ones = count[1];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private static int[] getZeroCount(String str) {
        int ones = 0;
        int zeros = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') zeros++;
            if (c == '1') ones++;
        }
        return new int[]{zeros, ones};
    }

    public static void main(String[] args) {

    }

}
