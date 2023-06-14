package 字符串;

public class 替换空格05 {

    public String replaceSpace(String s) {
        char[] newChars = new char[s.length() * 3];
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChars[j++] = '%';
                newChars[j++] = '2';
                newChars[j++] = '0';
            } else {
                newChars[j++] = chars[i];
            }
        }
        return new String(newChars, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(new 替换空格05().replaceSpace(" "));
    }

}
