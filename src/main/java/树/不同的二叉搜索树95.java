package 树;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树95 {
    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    private List<TreeNode> help(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start < end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {

        }
        return null;
    }
}
