package 动态规划;

public class 不同的二叉搜索树96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1]; // dp[i] i个节点有多少种二叉搜索树
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
