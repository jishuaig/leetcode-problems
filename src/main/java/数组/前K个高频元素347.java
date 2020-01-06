package 数组;

import java.util.*;

/**
 * Author: jishuai
 * Date: 2020/1/6
 */
public class 前K个高频元素347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // step 1 : 遍历数组获取所有元素的频次map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // step 2 : 建立一小顶堆
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int num : map.keySet()) {
            // step 3 : 依次入队列, 当数量大于k时，将频次较低的元素弹出，保留下最大的k个元素
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

}
