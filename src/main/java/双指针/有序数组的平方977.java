package 双指针;

import java.util.Arrays;

public class 有序数组的平方977 {

    public int[] sortedSquares(int[] nums) {
        int negative = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negative = i;
            }
        }
        int[] ans = new int[nums.length];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < nums.length) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                j++;
            } else if (j == nums.length) {
                ans[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] ans = new 有序数组的平方977().sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }

}
