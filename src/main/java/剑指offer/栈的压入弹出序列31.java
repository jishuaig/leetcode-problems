package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 栈的压入弹出序列31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] memory = new boolean[pushed.length];
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] != popped[0]) {
                stack.push(pushed[i]);
                memory[i] = true;
            }
        }
        for (int i = 0; i < popped.length; i++) {
            while (stack.peek() != popped[i]) {
                
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};

    }
}
