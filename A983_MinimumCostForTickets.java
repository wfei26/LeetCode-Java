import java.util.HashSet;
import java.util.Set;

public class A983_MinimumCostForTickets {
    public static void main(String[] args) {
        A983_MinimumCostForTickets solution = new A983_MinimumCostForTickets();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        int output = solution.mincostTickets(days, costs);
        System.out.println(output);
    }

    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        // store travel days in a set in order to get them in a quick way when we traverse all days
        // until to the last travel day
        for (int day : days) {
            travelDays.add(day);
        }

        int lastDay = days[days.length - 1];
        // sub-problem: dp[i] represents minimum ticket cost to the ith day
        int[] dp = new int[lastDay + 1];

        // we should traverse consecutive days which from the first day to the last day of input
        for (int i = 1; i <= lastDay; i++) {
            // if current day is not included in input, assign the same dp value as previous day and skip current iteration
            // because we at day i, we have already spent dp[i - 1] dollars, we have to assign a minimum value to dp[i]
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            // dp[i] is the minimum cost of trying three different tickets to today
            dp[i] = Integer.MAX_VALUE;
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }
        return dp[lastDay];
    }
}
