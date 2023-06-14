package 字符串;

public class 把字符串转换成整数67 {

    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        char[] c = str.toCharArray();
        if (str.length() == 0) return 0;
        int result = 0, start = 0, sign = 1, boundary = Integer.MAX_VALUE / 10;
        if (c[0] == '-') {
            sign = -1;
            start = 1;
        } else if (c[0] == '+') {
            start = 1;
        }
        for (int i = start; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9') break;
            if (result > boundary || (result == boundary && c[i] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (c[i] - '0');
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(new 把字符串转换成整数67().strToInt("-2147483648"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

}
