public class A198_HouseRobber {
    public static void main(String[] args) {
        A198_HouseRobber solution = new A198_HouseRobber();
        int[] myInputs = {2,1,7,9,1};
        int myResult = solution.rob(myInputs);
        System.out.println(myResult);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //Subproblem: dp(i) represents maximum profit from index 0 to i - 1 of nums
        int[] dp = new int[n + 1];

        //base case:
        //dp(0): we got nothing
        //dp(1): rob the first house
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < n + 1; i++) {
            //rob the house on i - 1 or do not rob the house on i - 1
            //depends on which one has greater profit
            //eg: dp[i - 2] + nums[i - 1] means max profit of nums 0 to i - 3 plus profit on i - 1
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}
