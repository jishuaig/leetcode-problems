package 动态规划.背包问题;

public class 国王挖金子 {

    public int getMaxGold(int[] mineValues, int[] mineWorkers, int works) {

        int mines = mineValues.length;
        int[][] dp = new int[mines][works + 1];// dp_0:前i个金矿 dp_1:剩余工人

        for (int j = 1; j <= works; j++) {
            dp[0][j] = j >= mineWorkers[0] ? mineValues[0] : 0;
        }

        for (int i = 1; i < mines; i++) {
            for (int j = 1; j <= works; j++) {
                dp[i][j] = dp[i - 1][j]; // 不选择该金矿
                if (j >= mineWorkers[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - mineWorkers[i]] + mineValues[i]);
                }
            }
        }

        return dp[mines - 1][works];
    }

    public static void main(String[] args) {
        int[] mineValues = new int[]{200, 300, 350, 400, 500};
        int[] mineWorkers = new int[]{3, 4, 3, 5, 5};
        int works = 10;
        System.out.println(new 国王挖金子().getMaxGold(mineValues, mineWorkers, works));
    }

}
