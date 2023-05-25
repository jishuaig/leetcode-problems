package 其他;

import java.util.Arrays;

public class 可能的二分法886 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int[] dislike : dislikes) {
            matrix[dislike[0]][dislike[1]] = matrix[dislike[1]][dislike[0]] = 1;
        }
        int[] record = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (record[i] == 0 && !dfs(matrix, record, i, 1, n)) return false;
        }
        return true;
    }

    public boolean dfs(int[][] matrix, int[] record, int index, int group, int n) {
        record[index] = group;
        for (int i = 1; i <= n; i++) {
            // 只遍历和自己相互讨厌的节点
            if (matrix[index][i] == 1) {
                if (record[i] == group) return false; // 讨厌的节点和自己放在了同一组
                if (record[i] == -group) continue; // 讨厌的节点和自己放在了对立组
                if (record[i] == 0 && !dfs(matrix, record, i, group * -1, n)) { // 讨厌的节点未赋值，则尝试把讨厌的节点放到另外一个组
                    return false;
                }
            }
        }
        return true;
    }


}
