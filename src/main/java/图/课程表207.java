package 图;

import java.util.LinkedList;

/**
 * Author: jishuai
 * Date: 2020/1/6
 */
public class 课程表207 {

    /**
     * 输入: 2, [[1,0]]
     * 输出: true
     * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
     * 思路：所有节点的入度为0，则可以完成
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        // step 1 : 遍历所有的边缘集合，算出所有节点的入度
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        // step 2 : 图的广度优先遍历，利用队列实现
        LinkedList<Integer> queue = new LinkedList<>();
        // step 3 : 入度为0的节点入队列
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            int p = queue.removeFirst();
            numCourses--;
            // step 4 : 遍历边缘集合，将与该节点相关的节点的入度 - 1，如果入度为0，入队列
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == p && --inDegrees[prerequisite[0]] == 0) {
                    queue.addLast(prerequisite[0]);
                }
            }
        }
        return numCourses == 0;
    }

}
