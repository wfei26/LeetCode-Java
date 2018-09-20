public class A312_BurstBallons {
    public static void main(String[] args) {
        A312_BurstBallons solution = new A312_BurstBallons();
        int[] inputs = {3,1,5,8};
        int output = solution.maxCoins(inputs);
        System.out.println(output);
    }

    public int maxCoins(int[] iNums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }

        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}
