package 剑指offer2;

import java.util.*;

public class 不含重复字符的最长子字符串 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int i = 0, j = 1;
        int ans = 1;
        Map<Character, Integer> map = new HashMap();
        map.put(s.charAt(0), 0);
        while (i < s.length() && j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int index = map.get(s.charAt(j)) + 1;
                for (int k = i; k < index; k++) {
                    map.remove(s.charAt(k));
                }
                i = index;
                map.put(s.charAt(j), j);
            } else {
                map.put(s.charAt(j), j);
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new 不含重复字符的最长子字符串().lengthOfLongestSubstring("tmmzuxt"));
    }

}
