package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 在排序数组中查找数字53 {

    public int search(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        int count = 0;
        int i = index;
        while (i >= 0 && nums[i--] == target) {
            count++;
        }
        i = index + 1;
        while (i >= 0 && i < nums.length && nums[i++] == target) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(new 在排序数组中查找数字53().search(nums, 6));

        List<Integer> numbers = new ArrayList<>();
        numbers.toArray(new Integer[0]);
    }
}
