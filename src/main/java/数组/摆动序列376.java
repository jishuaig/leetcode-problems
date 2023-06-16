package 数组;

import java.util.Arrays;

public class 摆动序列376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxUp = new int[nums.length];
        Arrays.fill(maxUp, 1);
        int[] maxDown = new int[nums.length];
        Arrays.fill(maxDown, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                int j = i - 1;
                while (j - 1 >= 0 && (nums[j] - nums[j - 1]) >= 0) {
                    j--;
                }
                maxUp[i] = maxDown[j] + 1;
            } else if (nums[i] - nums[i - 1] < 0) {
                int j = i - 1;
                while (j - 1 >= 0 && (nums[j] - nums[j - 1]) <= 0) {
                    j--;
                }
                maxDown[i] = maxUp[j] + 1;
            } else {
                int j = i - 1;
                while (j - 1 > 0 && nums[j] == nums[j - 1]) {
                    j--;
                }
                maxUp[i] = maxUp[j];
                maxDown[i] = maxDown[j];
            }
        }

        return Math.max(maxUp[nums.length - 1], maxDown[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new 摆动序列376().wiggleMaxLength(new int[]{1, 1, 1, 2, 2, 2, 1, 1, 1, 3, 3, 3, 2, 2, 2}));
    }
}
