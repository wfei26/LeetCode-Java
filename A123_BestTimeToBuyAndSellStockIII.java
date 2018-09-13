public class A123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        A123_BestTimeToBuyAndSellStockIII solution = new A123_BestTimeToBuyAndSellStockIII();
        int[] myInputs ={3,3,5,0,0,3,1,4};
        int myResult = solution.maxProfit(myInputs);
        System.out.println(myResult);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        if (len <= 4) {
            int result = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[ i - 1]) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }

        int[][] dp = new int[3][len];
        for (int i = 1; i <= 2; i++) {
            int curMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + curMax);
                curMax = Math.max(curMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[2][len - 1];
    }
}
