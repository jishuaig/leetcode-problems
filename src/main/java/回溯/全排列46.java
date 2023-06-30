package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列46 {

    // example :
    // 输入：nums = [1,2,3]
    // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            dfs(nums, queue, used, i);
        }

        return result;
    }

    public void dfs(int[] nums, LinkedList<Integer> queue, boolean[] used, int i) {
        queue.add(nums[i]);
        used[i] = true;
        if (queue.size() == nums.length) {
            result.add(new ArrayList<>(queue));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) continue;
            dfs(nums, queue, used, j);
            used[j] = false;
            queue.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new 全排列46().permute(new int[]{1, 2, 3});
        for (List<Integer> integers : permute) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

}
