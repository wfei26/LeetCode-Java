public class A746_MinCostClimbingStairs {
    public static void main(String[] args) {
        A746_MinCostClimbingStairs solution = new A746_MinCostClimbingStairs();
        int[] myInputs = {10,15,20};
        int myResult = solution.minCostClimbingStairs(myInputs);
        System.out.println(myResult);
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
