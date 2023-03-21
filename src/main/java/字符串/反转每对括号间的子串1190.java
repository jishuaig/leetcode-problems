package 字符串;

import java.util.ArrayDeque;
import java.util.Deque;

public class 反转每对括号间的子串1190 {

    public String reverseParentheses(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != ')') {
                deque.addLast(c);
            } else {
                StringBuilder str = new StringBuilder();
                while (!deque.isEmpty()) {
                    if (deque.peekLast() != '(') {
                        str.append(deque.pollLast());
                    } else {
                        deque.pollLast();
                        for (char c1 : str.toString().toCharArray()) {
                            deque.addLast(c1);
                        }
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.pollFirst());
        return sb.toString();
    }

    public void testReverseParentheses(){
        System.out.println(reverseParentheses("(abcd)"));
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static void main(String[] args) {
        new 反转每对括号间的子串1190().testReverseParentheses();
    }






}
