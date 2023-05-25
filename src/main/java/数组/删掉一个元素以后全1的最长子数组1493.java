package 数组;

public class 删掉一个元素以后全1的最长子数组1493 {

    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int[] pre = new int[n]; // 记录以nums[i]结尾的连续1数组长度
        int[] suf = new int[n]; // 记录以nums[i]开头的连续1数组长度

        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = nums[i] == 0 ? 0 : pre[i - 1] + 1;
        }

        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = nums[i] == 0 ? 0 : suf[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = i == 0 ? 0 : pre[i - 1];
            int s = i == n - 1 ? 0 : suf[i + 1];
            ans = Math.max(ans, p + s);
        }
        return ans;

    }

}
