package 动态规划;

public class 统计元音字母序列的数目1220 {

    public int countVowelPermutation(int n) {
        if (n < 1) return 0;
        long mod = 1000000007;
        long dp[][] = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % mod;
            dp[i][3] = (dp[i - 1][2]) % mod;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n][i];
        }
        return (int) (ans % mod);
    }

}
