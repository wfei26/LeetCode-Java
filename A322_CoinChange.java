public class A322_CoinChange {
    public static void main(String[] args) {
        A322_CoinChange solution = new A322_CoinChange();
        int[] inputs = {1, 2, 5};
        int output = solution.coinChange(inputs, 11);
        System.out.println(output);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int n = coins.length;
        //dp[i][j] represents the fewest number of coins that we need to make up amount
        //by using first i coins
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[1][i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                }
            }
        }
        return dp[n][amount];
    }
}
