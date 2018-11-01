public class A121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        A121_BestTimeToBuyAndSellStock solution = new A121_BestTimeToBuyAndSellStock();
        int[] myInputs ={7,1,5,3,6,4};
        int myResult = solution.maxProfit(myInputs);
        System.out.println(myResult);
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int result = 0;
        int curMaxProfit = 0;

        //since we are only allowed one transaction, we could simply add difference between
        //prices of two adjacent days, and accumulate to the curMaxProfit
        for (int i = 1; i < prices.length; i++) {
            curMaxProfit += prices[i] - prices[i - 1];
            //if current max profit is negative, ignore all transaction before and include
            //current transaction, it seems like we need to start a new trading process with
            //better profit
            curMaxProfit = Math.max(0, curMaxProfit);
            //iteratively update max result value
            result = Math.max(result, curMaxProfit);
        }
        return result;
    }
}
