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

        if (k >= len / 2) {
            int result = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[ i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int curMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + curMax);
                curMax = Math.max(curMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }
}
