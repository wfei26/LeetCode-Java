public class A673_NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        A673_NumberOfLongestIncreasingSubsequence solution = new A673_NumberOfLongestIncreasingSubsequence();
        int[] input = {1,3,5,4,7};
        int output = solution.findNumberOfLIS(input);
        System.out.println(output);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
