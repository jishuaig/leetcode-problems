package 数组;

public class 回旋打印矩阵 {

    public static String print(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        int ms = 0, me = matrix.length - 1,
                ns = 0, ne = matrix[0].length - 1;
        int direction = 1;
        while (ms <= ns && ns <= ne) {
            if (direction == 1) {
                for (int i = ms; i <= me; i++) {
                    System.out.println(matrix[ns][i]);
                    result.append(matrix[ns][i]);
                }
                ns += 1;
                direction = 2;
            } else if (direction == 2) {
                for (int i = ns; i <= ne; i++) {
                    System.out.println(matrix[i][me]);
                    result.append(matrix[i][me]);
                }
                me -= 1;
                direction = 3;
            } else if (direction == 3) {
                for (int i = me; i >= ms; i--) {
                    System.out.println(matrix[ne][i]);
                    result.append(matrix[ne][i]);
                }
                ne -= 1;
                direction = 4;
            } else {
                for (int i = ne; i >= ns; i--) {
                    System.out.println(matrix[ns][i]);
                    result.append(matrix[ns][i]);
                }
                ms += 1;
                direction = 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        System.out.println(print(matrix));
    }

}
