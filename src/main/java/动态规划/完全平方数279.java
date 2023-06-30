package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class 完全平方数279 {

    public int numSquares(int n) {

        List<Integer> squareInts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) break;
            squareInts.add(i * i);
        }
        int[][] dp = new int[squareInts.size()][n + 1]; // dp_0: 前i个数, dp_1: 和为j, dp: 最少数字
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= squareInts.size() - 1; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                int count = 1;
                while (count * squareInts.get(i) <= j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - count * squareInts.get(i)] + count);
                    count++;
                }
            }
        }

        return dp[squareInts.size() - 1][n];
    }

    public static void main(String[] args) {
        System.out.println(new 完全平方数279().numSquares(12));
    }

}
