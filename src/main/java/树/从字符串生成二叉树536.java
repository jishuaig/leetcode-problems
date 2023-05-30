package 树;

public class 从字符串生成二叉树536 {

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int firstLeftBracketIndex = s.indexOf("(");
        if (firstLeftBracketIndex == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        int rootVal = Integer.parseInt(s.substring(0, firstLeftBracketIndex));
        TreeNode root = new TreeNode(rootVal);
        int leftBracketIndex = firstLeftBracketIndex;
        int count = 0;
        for (int i = firstLeftBracketIndex; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count == 0 && leftBracketIndex == firstLeftBracketIndex) {
                root.left = str2tree(s.substring(leftBracketIndex + 1, i));
                leftBracketIndex = i + 1;
            } else if (count == 0 && leftBracketIndex != firstLeftBracketIndex) {
                root.right = str2tree(s.substring(leftBracketIndex + 1, i));
            }
        }
        return root;
    }


}
