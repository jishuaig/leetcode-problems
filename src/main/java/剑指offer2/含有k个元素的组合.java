package 剑指offer2;

import java.util.ArrayList;
import java.util.List;

public class 含有k个元素的组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n) return ans;
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            help(n, k, i, ans, temp);
        }
        return ans;
    }

    public void help(int n, int k, int i, List<List<Integer>> ans, List<Integer> temp) {
        temp.add(i);
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        }
        for (int j = i + 1; j <= n; j++) {
            help(n, k, j, ans, temp);
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new 含有k个元素的组合().combine(4, 2));
    }

}
