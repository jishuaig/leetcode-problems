package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三角形最小路径和120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = triangle.get(i).get(j);
                dp[i][j] = Integer.MAX_VALUE;
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + val);
                if (j < i) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + val);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    // 滚动数组，减少存储空间
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int val = triangle.get(i).get(j);
                dp[i % 2][j] = Integer.MAX_VALUE;
                if (j > 0) dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j - 1] + val);
                if (j < i) dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][j] + val);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[(m - 1) % 2][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new 三角形最小路径和120().minimumTotal2(triangle));
    }

}
