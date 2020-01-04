package 其他;

public class 比较版本号165 {

    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < ver1.length || j < ver2.length) {
            String num1 = i < ver1.length ? ver1[i] : "0";
            String num2 = j < ver2.length ? ver2[j] : "0";
            int res = compare(num1, num2);
            if (res == 0) {
                i++;
                j++;
            } else
                return res;
        }
        return 0;
    }

    private int compare(String s1, String s2) {
        Integer a = Integer.parseInt(s1);
        Integer b = Integer.parseInt(s2);
        return a.compareTo(b);
    }


    public static void main(String[] args) {
        // System.out.println("1".compareTo("001"));
        System.out.println(new 比较版本号165().compareVersion("1.01", "1"));
    }

}
