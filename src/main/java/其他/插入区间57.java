package 其他;

import java.util.LinkedList;

public class 插入区间57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 初始化参数
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // 遍历列表，把位于新区间之前的区间添加到out
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // add newInterval
        int[] interval = new int[2];
        // 如果新区间在所有之前或者在所有之后
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) output.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                new int[]{1, 2},
                new int[]{3, 5},
                new int[]{6, 7},
                new int[]{8, 10},
                new int[]{12, 16}
        };
        int[] newInterval = new int[]{4, 8};
        new 插入区间57().insert(intervals, newInterval);
    }

}
