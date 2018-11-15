public class A322_CoinChange {
    public static void main(String[] args) {
        A322_CoinChange solution = new A322_CoinChange();
        int[] inputs = {1,2,5};
        int output = solution.coinChange(inputs, 11);
        System.out.println(output);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
            return 0;
        }

        //Subproblem: dp(i) represents min number of coins needed for amount i
        int[] dp = new int[amount + 1];

        //Base cases: initialize dp(i), 1 <= i <= amount to MAX value
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        //Recurrence relation: dp(i) = min(dp(i), dp(i - coin) + 1)
        //if coin <= i: current coin's denomination value cannot be greater than amount
        //&& dp(i - coin) != MAX: the amount "i - coin" has already been updated before
        //in order to avoid the case Integer.MAX_VALUE + 1
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                //WARNING: MUST determine if previous amount has been updated
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        //must check if dp value has been updated
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}
