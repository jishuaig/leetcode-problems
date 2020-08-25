package 树;

public class 验证二叉树1361 {

    int find = 0;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 入度检查
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) in[leftChild[i]]++;
            if (rightChild[i] != -1) in[rightChild[i]]++;
        }
        int root = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) root = i;
            if (in[i] > 2) return false;
        }
        // 连通性检查，从根节点开始
        help(root, leftChild, rightChild);
        return find == n;
    }

    private void help(int n, int[] leftChild, int[] rightChild) {
        find++;
        int left = leftChild[n];
        int right = rightChild[n];
        leftChild[n] = -1;
        rightChild[n] = -1;
        if (left != -1)
            help(left, leftChild, rightChild);
        if (right != -1)
            help(right, leftChild, rightChild);
    }
}
