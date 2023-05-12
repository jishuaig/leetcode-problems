package 深度优先;

public class 岛屿的最大面积105 {

    private static final int[] di = new int[]{0, 0, 1, -1};

    private static final int[] dj = new int[]{1, -1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        for (int dir = 0; dir < 4; dir++) { // 遍历当前格的四个方向
            int next_i = i + di[dir], next_j = j + dj[dir];
            ans += dfs(grid, next_i, next_j);
        }
        return ans;
    }

}
