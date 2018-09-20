public class A312_BurstBalloons {
    public static void main(String[] args) {
        A312_BurstBalloons solution = new A312_BurstBalloons();
        int[] inputs = {3,1,5,8};
        int output = solution.maxCoins(inputs);
        System.out.println(output);
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //extend the input array by 2, to virtually add two invisible balloons at the front and end with value 1
        //so that two balloons at left and right boundary can have product with these two virtual balloons
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        //we need to extend length of dp array as well
        int[][] dp = new int[n + 2][n + 2];
        //in order to solve larger problems, we need to solve smaller sub-problems firstly.
        //we start from len 1 to len n to solve each sub-problems
        for (int len = 1; len <= n; len++) {
            //i means left pointer, j means right pointer
            //the length from i to j is fixed, should be i + len - 1;
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                //k means the position of last balloon (that will burst)
                //when we have fixed left and right pointer, we need to move k from left to right to
                //find the best k position to get max coins.
                //from i to k - 1 (left of k) and k + 1 to j (right of k), we can get max value from
                //previous sub-problems, so that we can dynamically calculate max value of
                //max(left + nums[i - 1] * nums[k] * nums[j + 1] + right)
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[k + 1][j]);
                }
            }
        }
        //caution: DO NOT RETURN dp[0][n - 1] because we already extend the dp size by 2, the valid number
        //in dp array is from index 1 to index n, which is also the max valid length we could get in dp array
        //dp[0][*] and dp[*][n + 1] should be 0, since we never assign any valid value to there
        return dp[1][n];
    }
}
