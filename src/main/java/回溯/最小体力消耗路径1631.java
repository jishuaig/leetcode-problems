package 回溯;

public class 最小体力消耗路径1631 {

    static int m = 0;
    static int n = 0;
    static int result = 0;

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        result = Integer.MAX_VALUE;
        boolean[][] memory = new boolean[m][n];
        backTrack(heights, memory, 0, 0, 0);
        return result;
    }

    public void backTrack(int[][] heights, boolean[][] memory, int i, int j, int ans) {
        if (memory[i][j]) {
            return;
        }
        if (i == m - 1 && j == n - 1) {
            result = Math.min(result, ans);
            return;
        }
        memory[i][j] = true;
        int height = heights[i][j];
        if (i + 1 < m) {
            backTrack(heights, memory, i + 1, j, Math.max(ans, Math.abs(height - heights[i + 1][j])));
        }
        if (i - 1 >= 0) {
            backTrack(heights, memory, i - 1, j, Math.max(ans, Math.abs(height - heights[i - 1][j])));
        }
        if (j + 1 < n) {
            backTrack(heights, memory, i, j + 1, Math.max(ans, Math.abs(height - heights[i][j + 1])));
        }
        if (j - 1 >= 0) {
            backTrack(heights, memory, i, j - 1, Math.max(ans, Math.abs(height - heights[i][j - 1])));
        }
        memory[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{new int[]{1,10,6,7,9,10,4,9}};
        System.out.println(new 最小体力消耗路径1631().minimumEffortPath(heights));
    }

}
