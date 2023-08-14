package 动态规划;

public class 最低票价983 {

    public int mincostTickets(int[] days, int[] costs) {
        int startDay = days[0];
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 31];
        int i = days.length - 1;
        for (int day = lastDay; day >= startDay; day--) {
            if (day == days[i]) {
                dp[day] = Math.min(dp[day + 1] + costs[0], dp[day + 7] + costs[1]);
                dp[day] = Math.min(dp[day], dp[day + 30] + costs[2]);
                i--;
            } else {
                dp[day] = dp[day + 1];
            }
        }
        return dp[startDay];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(new 最低票价983().mincostTickets(days, costs));
    }

}
