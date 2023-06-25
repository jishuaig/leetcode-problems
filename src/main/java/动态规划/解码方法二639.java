package 动态规划;

public class 解码方法二639 {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            dp[0] = 1;
        } else if (s.charAt(0) == '*') {
            dp[0] = 9;
        }
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char pre = s.charAt(i - 1);
            if (cur == '*') {
                dp[i] += dp[i - 1] * 9;
                // 解码的时候算前一个数字
                int preCount = i - 2 >= 0 ? dp[i - 2] : 1;
                if (pre == '*') {
                    dp[i] += preCount * 15; // ** 情况
                } else if (pre == '1') {
                    dp[i] += preCount * 9; // 1* 情况
                } else if (pre == '2') {
                    dp[i] += preCount * 6; // 2* 情况
                }
            } else {
                if (pre == '0') {
                    dp[i] += dp[i - 1] * 9;
                }
            }
        }
        return 0;
    }

}
