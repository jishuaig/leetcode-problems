package 动态规划;

import java.util.Arrays;

public class 最小路径和64 {

    int m = 0;
    int n = 0;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int[] g = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int top = i - 1 >= 0 ? dp[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? dp[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(top, left);
                    // 状态转移路径保存到g数组中
                    g[getIndex(i, j)] = top < left ? getIndex(i - 1, j) : getIndex(i, j - 1);
                }
            }
        }

        int[][] path = new int[m + n - 1][2];

        int idx = getIndex(m - 1, n - 1);
        for (int i = 0; i < path.length; i++) {
            path[m + n - 2 - i] = new int[]{parseIndex(idx)[0], parseIndex(idx)[1]};
            idx = g[idx];
        }

        for (int[] ints : path) {
            System.out.println(Arrays.toString(ints));
        }


        return dp[m - 1][n - 1];
    }

    private int getIndex(int x, int y) {
        return x * m + y;
    }

    private int[] parseIndex(int index) {
        int[] result = new int[2];
        result[0] = index / m;
        result[1] = index % m;
        return result;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}};

        System.out.println(new 最小路径和64().minPathSum(grid));

    }

}