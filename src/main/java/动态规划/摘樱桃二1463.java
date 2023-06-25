package 动态规划;

import java.util.Arrays;

public class 摘樱桃二1463 {

    public int cherryPickup(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] f = new int[col][col];
        int[][] g = new int[col][col];

        for (int i = 0; i < col; i++) {
            Arrays.fill(f[i], -1);
            Arrays.fill(g[i], -1);
        }

        f[0][col - 1] = grid[0][0] + grid[0][col - 1];
        for (int i = 0; i < row; i++) {
            for (int j1 = 0; j1 < col; j1++) {
                for (int j2 = 0; j2 < col; j2++) {
                    int best = -1;
                    for (int dj1 = j1 - 1; dj1 <= j1 + 1; dj1++) {
                        for (int dj2 = j2 - 1; dj2 <= j2 + 1; dj2++) {
                            if (dj1 >= 0 && dj1 < col && dj2 >= 0 && dj2 < col && f[dj1][dj2] != -1) {
                                best = Math.max(best, f[dj1][dj2] + (j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2]));
                            }
                        }
                    }
                    g[j1][j2] = best;
                }
            }
            int[][] temp = f;
            f = g;
            g = temp;
        }
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }
}
