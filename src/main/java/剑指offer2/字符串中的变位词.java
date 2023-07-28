package 剑指offer2;

import java.util.Arrays;

public class 字符串中的变位词 {

    /**
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        int[] map1 = new int[26];
        int[] mapK = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            mapK[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(map1, mapK)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            mapK[s2.charAt(i) - 'a']++;
            mapK[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(map1, mapK)) {
                return true;
            }
        }
        return false;
    }
}
