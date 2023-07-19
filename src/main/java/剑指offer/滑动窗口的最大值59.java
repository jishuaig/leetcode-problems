package 剑指offer;

import java.util.PriorityQueue;

public class 滑动窗口的最大值59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            q.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = q.peek()[0];
        for (int i = k; i < nums.length; i++) {
            q.offer(new int[]{nums[i], i});
            while (q.peek()[1] <= i - k) {
                q.poll();
            }
            ans[i - k + 1] = q.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(new 滑动窗口的最大值59().maxSlidingWindow(nums, 3));
    }

}
