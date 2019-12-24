/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package 树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 不同的二叉搜索树95 {
    public List<TreeNode> generateTrees(int n) {
        return help(1, n);
    }

    private List<TreeNode> help(int start, int end) {
        if(start > end){
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        };
        List<TreeNode> trees = new ArrayList<>();
        for (int i = start; i <= end ; i++) {
            for (TreeNode left : help(start, i - 1)) {
                for (TreeNode right : help(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }


    public static void main(String[] args) {
    }
}
