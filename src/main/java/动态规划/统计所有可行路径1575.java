package 动态规划;

import java.util.Arrays;

public class 统计所有可行路径1575 {

    int mod = 1000000007;
    int[][] cache; // 表示位置cache[i][fuel] 从当前位置i出发，剩余油量为fuel的情况下，到达目标路径的"路径数量"

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1); // -1 表示未计算过， 0和其他表示路径数量
        }
        return dfs(locations, start, finish, fuel);
    }

    public int dfs(int[] locations, int i, int j, int fuel) {
        if (cache[i][fuel] != -1) {
            return cache[i][fuel];
        }
        int need = Math.abs(locations[i] - locations[j]);
        if (need > fuel) {
            cache[i][fuel] = 0; // 如果i无法通过油量fuel到达j，则方案数为0
        }
        int n = locations.length;
        int sum = i == j ? 1 : 0;
        for (int k = 0; k < n; k++) {
            if (k != i) {
                need = Math.abs(locations[k] - locations[i]);
                if (fuel >= need) {
                    sum += dfs(locations, k, j, fuel - need);
                    sum %= mod;
                }
            }
        }
        cache[i][fuel] = sum;
        return sum;
    }

    public int countRoutes2(int[] locations, int start, int finish, int fuel) {
        int[][] dp = new int[locations.length][fuel + 1]; // 位置i剩余油量fuel，到达目标的路径数量
        for (int i = 0; i <= fuel; i++) {
            dp[finish][i] = 1;
        }
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations.length; j++) {
                    if (j != i) {
                        int need = Math.abs(locations[i] - locations[j]);
                        if (cur >= need) {
                            dp[i][cur] += dp[j][fuel - need];
                            dp[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}
