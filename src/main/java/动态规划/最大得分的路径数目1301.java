package 动态规划;

import java.util.Arrays;
import java.util.List;

public class 最大得分的路径数目1301 {

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] array = new char[n][n];
        for (int i = 0; i < board.size(); i++) {
            array[i] = board.get(i).toCharArray();
        }
        int[][] dpScore = new int[n][n]; // 起始位置到当前位置最大得分
        int[][] dpRoute = new int[n][n]; // 起始位置到当前位置最大得分方案数量


        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    // 初始化dp数组，当位于起始点时
                    dpRoute[n - 1][n - 1] = 1;
                    continue;
                }
                if (array[i][j] == 'X') {
                    dpScore[i][j] = Integer.MIN_VALUE;
                    continue;
                }
                int val = i == 0 && j == 0 ? 0 : array[i][j] - '0';
                int maxScore = Integer.MIN_VALUE;
                int maxScoreRoutes = 0;
                if (i + 1 < n) {
                    int score = dpScore[i + 1][j] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dpScore[i + 1][j] + val;
                    int routes = dpRoute[i + 1][j];
                    int[] update = update(score, routes, maxScore, maxScoreRoutes);
                    maxScore = update[0];
                    maxScoreRoutes = update[1];
                }
                if (j + 1 < n) {
                    int score = dpScore[i][j + 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dpScore[i][j + 1] + val;
                    int routes = dpRoute[i][j + 1];
                    int[] update = update(score, routes, maxScore, maxScoreRoutes);
                    maxScore = update[0];
                    maxScoreRoutes = update[1];
                }
                if (i + 1 < n && j + 1 < n) {
                    int score = dpScore[i + 1][j + 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dpScore[i + 1][j + 1] + val;
                    int routes = dpRoute[i + 1][j + 1];
                    int[] update = update(score, routes, maxScore, maxScoreRoutes);
                    maxScore = update[0];
                    maxScoreRoutes = update[1];
                }
                dpScore[i][j] = maxScore;
                dpRoute[i][j] = maxScoreRoutes;
            }
        }
        return new int[]{dpScore[0][0] == Integer.MIN_VALUE ? 0 : dpScore[0][0], dpRoute[0][0]};
    }

    private int[] update(int score, int routes, int maxScore, int maxScoreRoutes) {
        int[] result = new int[]{maxScore, maxScoreRoutes};
        if (score > maxScore) {
            result[0] = score;
            result[1] = routes;
        } else if (score == maxScore && score != Integer.MIN_VALUE) {
            result[1] += routes;
        }
        result[1] = result[1] % (int) (1e9 + 7);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new 最大得分的路径数目1301().pathsWithMaxScore(Arrays.asList("E11", "XXX", "11S"))));
    }


}
