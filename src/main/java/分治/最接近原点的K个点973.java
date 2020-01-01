package 分治;

import java.util.Arrays;

public class 最接近原点的K个点973 {

    public int[][] kClosest(int[][] points, int K) {
        int start = 0;
        int end = points.length - 1;
        while (start < end) {
            int index = partition(points, start, end);
            if (index == K) {
                break;
            } else if (index < K) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }

        return Arrays.copyOf(points, K);
    }

    private int partition(int[][] points, int start, int end) {
        int i = start;
        int j = end + 1;
        int mid = distance(points[i][0], points[i][1]);
        while (true) {
            while (distance(points[++i][0], points[i][1]) < mid && i < end) ;
            while (distance(points[--j][0], points[j][1]) > mid && j > start) ;
            if (i >= j) {
                break;
            }
            swap(points, i, j);
        }
        swap(points, start, j);
        return j;
    }

    private int distance(int a, int b) {
        return a * a + b * b;
    }

    private void swap(int[][] points, int a, int b) {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}
