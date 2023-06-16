package 数组;

import java.util.Arrays;

public class 恢复数组1416 {

    private final static int mod= 1000000007 ;

    public int numberOfArrays(String s, int k) {
        // 以i为结尾的 有效方案次数
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0 && i - j <= 10; j--) {
                if (s.charAt(j) == '0' && j != i) {
                    continue;
                }
                long num = Long.parseLong(s.substring(j, i + 1));
                if (num >= 1 && num <= k) {
                    dp[i] += j == 0 ? 1 : dp[j - 1];
                    dp[i] %= mod;
                } else if (num > k) {
                    break;
                }
            }
        }
        // Arrays.stream(dp).forEach(num -> System.out.println(num + " "));
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println("result = " + new 恢复数组1416().numberOfArrays("2020", 30));
    }


}
