package 其他;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角II119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++) {
            cur = new ArrayList<>();
            for (int i = 0; i <= j; i++) {
                if (i == 0 || i == j) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(i) + pre.get(i - 1));
                }
            }
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        new 杨辉三角II119().getRow(3).forEach(System.out::println);
    }
}
