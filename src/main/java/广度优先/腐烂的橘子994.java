package 广度优先;

import java.util.LinkedList;

public class 腐烂的橘子994 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }
        int round = 0;
        while (freshCount > 0 && !queue.isEmpty()) {
            round++;
            int badCount = queue.size();
            for (int i = 0; i < badCount; i++) {
                int[] bad = queue.poll();
                int bad_i = bad[0];
                int bad_j = bad[1];
                if (bad_i > 0 && grid[bad_i - 1][bad_j] == 1) {
                    grid[bad_i - 1][bad_j] = 2;
                    queue.addLast(new int[]{bad_i - 1, bad_j});
                    freshCount--;
                }
                if (bad_i < m - 1 && grid[bad_i + 1][bad_j] == 1) {
                    grid[bad_i + 1][bad_j] = 2;
                    queue.addLast(new int[]{bad_i + 1, bad_j});
                    freshCount--;
                }
                if (bad_j > 0 && grid[bad_i][bad_j - 1] == 1) {
                    grid[bad_i][bad_j - 1] = 2;
                    queue.addLast(new int[]{bad_i, bad_j - 1});
                    freshCount--;
                }
                if (bad_j < n - 1 && grid[bad_i][bad_j + 1] == 1) {
                    grid[bad_i][bad_j + 1] = 2;
                    queue.addLast(new int[]{bad_i, bad_j + 1});
                    freshCount--;
                }
            }
        }
        return freshCount > 0 ? -1 : round;
    }

}
