package 动态规划;

import java.util.List;

public class 三角形最小路径和120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(0).size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        for (int i = dp.length - 2; i >= 1; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + dp[i][j];
            }
        }
        return dp[0][0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int lastLevel = triangle.size() - 1;
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.get(lastLevel).size(); i++) {
            dp[i] = triangle.get(lastLevel).get(i);
        }
        for (int i = lastLevel - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}
