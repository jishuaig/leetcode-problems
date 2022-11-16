package 动态规划;

import java.util.Arrays;

public class 出界的路径数576 {

    int[][][] cache; // 当前位置i，j, 剩余次数为maxMove 路径数量
    int m;
    int n;
    int mod = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        this.m = m;
        this.n = n;
        return dfs(startRow, startColumn, maxMove);
    }

    public int dfs(int i, int j, int maxMove) {
        if (maxMove < 0) {
            return 0;
        }
        if (i < 0 || i > m - 1) {
            return 1;
        }
        if (j < 0 || j > n - 1) {
            return 1;
        }
        if (cache[i][j][maxMove] != -1) {
            return cache[i][j][maxMove];
        }
        int ans = 0;
        ans += dfs(i - 1, j, maxMove - 1);
        ans %= mod;
        ans += dfs(i + 1, j, maxMove - 1);
        ans %= mod;
        ans += dfs(i, j - 1, maxMove - 1);
        ans %= mod;
        ans += dfs(i, j + 1, maxMove - 1);
        ans %= mod;
        cache[i][j][maxMove] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new 出界的路径数576().findPaths(2 ,2, 2, 0, 0));
        System.out.println(new 出界的路径数576().findPaths(8, 50, 23, 5, 26));
    }

}
