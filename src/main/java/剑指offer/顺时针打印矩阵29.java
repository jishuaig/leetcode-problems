package 剑指offer;

import java.util.Arrays;

public class 顺时针打印矩阵29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m * n];
        int rowUp = 0;
        int rowDown = m - 1;
        int colLeft = 0;
        int colRight = n - 1;
        int dir = 1;
        int k = 0;
        while (k < m * n) {
            if (dir == 1) {
                for (int i = colLeft; i <= colRight; i++) {
                    ans[k++] = matrix[rowUp][i];
                }
                rowUp += 1;
                dir = 2;
            } else if (dir == 2) {
                for (int i = rowUp; i <= rowDown; i++) {
                    ans[k++] = matrix[i][colRight];
                }
                colRight -= 1;
                dir = 3;
            } else if (dir == 3) {
                for (int i = colRight; i >= colLeft; i--) {
                    ans[k++] = matrix[rowDown][i];
                }
                rowDown--;
                dir = 4;
            } else if (dir == 4) {
                for (int i = rowDown; i >= rowUp; i--) {
                    ans[k++] = matrix[i][colLeft];
                }
                colLeft += 1;
                dir = 1;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int[] ans = new 顺时针打印矩阵29().spiralOrder(nums);
        System.out.println(Arrays.toString(ans));
    }
}
