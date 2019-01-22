public class A188_BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        A188_BestTimeToBuyAndSellStockIV solution = new A188_BestTimeToBuyAndSellStockIV();
        int[] myInputs ={3,2,6,5,0,3};
        int myResult = solution.maxProfit(2, myInputs);
        System.out.println(myResult);
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        // to avoid memory limit exceeded error, we can optimize our solution
        // if we are allowed to do len/2 or more transactions, we can convert to problem of Stock II by using greedy algorithm
        if (k >= len / 2) {
            int result = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[ i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        /* sub-problem:
         * dp[i][j] represents max profit of first j + 1 prices by making i transactions
         *
         * base case:
         * dp[0][j] = 0 for 0 < j < prices.length, since 0 transaction will have no profit
         * dp[i][0] = 0 for 0 < i <= k, since there does not have any available prices
         */
        int[][] dp = new int[k + 1][len];

        /* recurrence relation */
        for (int i = 1; i <= k; i++) {
            // assume we buy stock at the first price
            int prevMax = -prices[0];
            for (int j = 1; j < len; j++) {
                /* dp[i][j] deciding the selling point
                *  Similar to 0-1 knapsack problem, we have two candidates at here (use or not use):
                *  1. do not use current new available price:
                *     keep previous max profit dp[i][j-1] at current new available price without doing any new transaction
                *  2. use current new available price:
                *     throw previous max up, update new max profit by doing one more transaction at current new price
                *  By comparing these two max profit, we will keep the one with max value, and assign to dp[i][j]
                * */
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + prevMax);

                /* preMax deciding the buying point
                *  in order to prepare previous price state for dp[i][j] in next iteration, we need to calculate
                *  whether we want to use current price as buying price :
                *  1. if we do not use one more transaction chance to buy new stock, and keep original buying price:
                *     keep previous max profit, as preMax
                *  2. if we use one more transaction chance to buy new stock:
                *     use previous max profit with i - 1 transaction dp[i-1][j] minus new buying price, price[j],
                *     then we will decide new max profit in next iteration
                * */
                prevMax = Math.max(prevMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
}
