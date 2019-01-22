public class A309_BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        A309_BestTimeToBuyAndSellStockWithCooldown solution = new A309_BestTimeToBuyAndSellStockWithCooldown();
        int[] myInput = {2,1};
        int myResult = solution.maxProfit(myInput);
        System.out.println(myResult);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[] s0 = new int[len]; //start state (or state after rest)
        int[] s1 = new int[len]; //state after buying
        int[] s2 = new int[len]; //state after selling

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            // for current state of s0, we may stay on s0 state to rest many days, or transfer from s2 state to rest one day
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);

            // for current state of s1, we may stay on s1 state to rest many days (wait better opportunity to buy)
            // or transfer from s0 state to buy at current price
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);

            // for current state of s2, we may stay on s2 state to rest many days (wait better opportunity to sell)
            // or transfer from s1 state to sell (at current price) on the second day after buying
            s2[i] = Math.max(s2[i - 1], s1[i - 1] + prices[i]);
        }
        return Math.max(s0[len - 1], s2[len - 1]);
    }
}
