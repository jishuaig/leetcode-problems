package 数组;

public class 搜索二维矩阵74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j < n) {
            int num = matrix[i][j];
            if (num == target) return true;
            else if (num > target) i++;
            else j--;
        }
        return false;
    }

}
