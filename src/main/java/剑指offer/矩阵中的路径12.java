package 剑指offer;

public class 矩阵中的路径12 {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return false;
        if (board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] memory = new boolean[board.length][board[0].length];
                    if (help(board, memory, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, boolean[][] memory, String word, int index, int i, int j) {
        if (i < 0 || i > board.length - 1) return false;
        if (j < 0 || j > board[0].length - 1) return false;
        if (index > word.length() - 1) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (memory[i][j]) return false;
        memory[i][j] = true;
        if (index == word.length() - 1) return true;
        boolean result = help(board, memory, word, index + 1, i + 1, j)
                || help(board, memory, word, index + 1, i - 1, j)
                || help(board, memory, word, index + 1, i, j + 1)
                || help(board, memory, word, index + 1, i, j - 1);
        memory[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] bord = new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'E', 'S'}, new char[]{'A', 'D', 'E', 'E'}};
        System.out.println(new 矩阵中的路径12().exist(bord, "ABCED"));
    }

}
