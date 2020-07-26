package 动态规划;

public class 矩阵中的最长递增路径329 {

    private static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int m;
    private static int n;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans = Math.max(dfs(i, j, matrix, memo), ans);
            }
        }
        return ans;
    }

    private static int dfs(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0) return memo[row][col];
        ++memo[row][col];
        for (int[] d : dir) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col], dfs(newRow, newCol, matrix, memo) + 1);
            }
        }
        return memo[row][col];
    }

}
