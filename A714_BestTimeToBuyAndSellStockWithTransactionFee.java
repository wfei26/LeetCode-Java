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

        int result = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {

        }

        return result;
    }
}
