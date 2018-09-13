public class A121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        A121_BestTimeToBuyAndSellStock solution = new A121_BestTimeToBuyAndSellStock();
        int[] myInputs ={7,1,5,3,6,4};
        int myResult = solution.maxProfit(myInputs);
        System.out.println(myResult);
    }


    public int maxProfit(int[] prices) {
        int curMax = 0, resultMax = 0;
        for (int i = 1; i < prices.length; i++) {
            curMax += prices[i] - prices[i - 1];
            curMax = Math.max(0, curMax);
            resultMax = Math.max(resultMax, curMax);
        }
        return resultMax;
    }
}
