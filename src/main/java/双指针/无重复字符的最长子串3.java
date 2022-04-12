package 双指针;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
public class 无重复字符的最长子串3 {

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> charMap = new HashMap<>(); // [start, end] 数组内"字符出现的个数映射"
        for (int start = 0, end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            charMap.put(endChar, charMap.getOrDefault(endChar, 0) + 1);
            while (charMap.get(endChar) > 1) {
                char startChar = s.charAt(start);
                charMap.put(startChar, charMap.get(startChar) - 1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

}
