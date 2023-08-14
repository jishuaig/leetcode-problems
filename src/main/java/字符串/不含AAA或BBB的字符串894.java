package 字符串;

import java.util.ArrayList;
import java.util.List;

public class 不含AAA或BBB的字符串894 {

    static int total = 0;
    static List<String> result = new ArrayList<>();

    public String strWithout3a3b(int a, int b) {
        total = a + b;
        result = new ArrayList<>();
        help("", a, b);
        return result.isEmpty() ? "" : result.get(0);
    }

    public void help(String str, int a, int b) {
        if (a < 0 || b < 0) {
            return;
        }
        if (str.length() == total) {
            result.add(str);
            return;
        }
        if (str.length() <= 1) {
            if ("".equals(str) || "a".equals(str) || "b".equals(str)) {
                help(str + 'a', a - 1, b);
                help(str + 'b', a, b - 1);
            }
        } else {
            String last2 = str.substring(str.length() - 2);
            if ("aa".equals(last2)) {
                help(str + 'b', a, b - 1);
            } else if ("bb".equals(last2)) {
                help(str + 'a', a - 1, b);
            } else {
                help(str + 'a', a - 1, b);
                help(str + 'b', a, b - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 不含AAA或BBB的字符串894().strWithout3a3b(1, 2));
    }

}
