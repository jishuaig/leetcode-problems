package 深度优先;

public class 统计封闭岛屿的数目1254 {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0 && dfs(grid, visited, rows, cols, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int[][] visited, int rows, int cols, int i, int j) {
        // 超出边界，则未找到岛屿
        if (i >= rows || i < 0 || j >= cols || j < 0) return false;
        // 如果当前块是海水，或者已经访问过
        if (grid[i][j] == 1 || visited[i][j] == 1) return true;
        boolean result = true;
        visited[i][j] = 1;
        for (int[] dir : dirs) {
            if (!dfs(grid, visited, rows, cols, i + dir[0], j + dir[1])) {
                result = false;
                break;
            }
        }
        return result;
    }


}
