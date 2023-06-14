package 字符串;

import java.util.HashMap;
import java.util.Map;

public class 左旋转字符串58 {

    public String reverseLeftWords(String s, int n) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - 1 - n);
        reverse(chars, chars.length - n, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new 左旋转字符串58().reverseLeftWords("abcdefg", 2));
        Map<Integer, Integer> test = new HashMap<Integer, Integer>() {
            {
                put(1, 1);
            }
        };
    }

}
