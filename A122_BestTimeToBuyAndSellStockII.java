public class A122_BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        A122_BestTimeToBuyAndSellStockII solution = new A122_BestTimeToBuyAndSellStockII();
        int[] myInputs ={7,1,5,3,6,4};
        int myResult = solution.maxProfit(myInputs);
        System.out.println(myResult);
    }

    /** By greedy algorithm, we will try to accumulate profit when next day price is greater than previous day price*/
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
