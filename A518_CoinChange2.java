public class A518_CoinChange2 {
    public static void main(String[] args) {
        A518_CoinChange2 solution = new A518_CoinChange2();
        int[] input = {1,2,5};
        int output = solution.change(5, input);
        System.out.println(output);
    }

    public int change(int amount, int[] coins) {
        //Subproblem: dp(i) represents number of combinations to make amount i
        int[] dp = new int[amount + 1];
        //Base case: dp(0) = 1, because we will start to iterate with dp(1), and dp(1) = dp(1) + dp(1 - 1)
        dp[0] = 1;

        /*
        * Recurrence relation: dp(i) += dp(i - coin)
        * It means when we have a new denomination, we could have dp(i - coin) new combinations
        * the outer loop must be coins. there may exist duplicate combination if coins is inner loop
        * eg: dp[3] += dp[3 - 1] when coin = 1, dp[3] += dp[3 - 2] when coin = 2
        * but 1 + 2 and 2 + 1 are actually count as one combination
        * */
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
