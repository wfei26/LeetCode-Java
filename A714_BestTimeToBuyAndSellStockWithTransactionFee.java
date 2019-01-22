public class A714_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        A714_BestTimeToBuyAndSellStockWithTransactionFee solution = new A714_BestTimeToBuyAndSellStockWithTransactionFee();
        int[] myInputs ={1, 3, 2, 8, 4, 9};
        int myResult = solution.maxProfit(myInputs, 2);
        System.out.println(myResult);
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        // sub-problem: buy[i] represents max profit if we buy stock at price i
        // sell[i] represents max profit if we sell stock at price i
        int[] buy = new int[len];
        int[] sell = new int[len];

        // base case: buy stock at the first day
        buy[0] = - prices[0] - fee;
        for (int i = 1; i < len; i++) {
            // check if we have lower buying price at day i
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee);
            // check if we have higher selling price at day i
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[len - 1];
    }
}
