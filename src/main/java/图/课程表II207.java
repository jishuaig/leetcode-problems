package 图;

import java.util.LinkedList;

/**
 * Author: jishuai
 * Date: 2020/1/6
 */
public class 课程表II207 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        int[] result = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.addLast(i);
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            result[k++] = course;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course && --inDegrees[prerequisite[0]] == 0) {
                    queue.addLast(prerequisite[0]);
                }
            }
        }
        if (k != numCourses) return null;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new 课程表II207().findOrder(2, new int[][]{new int[]{1, 0}}));
    }

}
