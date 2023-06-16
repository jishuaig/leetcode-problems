package 字符串;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 最长字符串链1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>(); // key -> 当前结尾字符串 ||  value -> 最大长度
        for (String word : words) {
            map.put(word, 1);
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                StringBuilder builder = new StringBuilder(word);
                String pre = builder.deleteCharAt(j).toString();
                if (map.containsKey(pre)) {
                    map.put(word, Math.max(map.get(word), map.get(pre) + 1));
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 最长字符串链1048().longestStrChain(new String[]{"a"}));
    }

}
