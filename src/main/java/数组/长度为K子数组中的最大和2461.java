package 数组;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class 长度为K子数组中的最大和2461 {

    // [1,5,4,2,9,9,9]
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        Set<Integer> window = new HashSet<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            while (window.contains(nums[i])) {
                window.remove(nums[start++]);
            }
            window.add(nums[i]);
            if (window.size() >= k) {
                max = Math.max(max, pre[i] - (i - k >= 0 ? pre[i - k] : 0));
            }
        }
        return max;
    }


    public static void main(String[] args) {
        // 生成 1，4，3数组
        int[] nums = Stream.of(1,1,1,7,8,9).mapToInt(Integer::intValue).toArray();
        long result = new 长度为K子数组中的最大和2461().maximumSubarraySum(nums, 3);
        System.out.println(result);

    }

}
