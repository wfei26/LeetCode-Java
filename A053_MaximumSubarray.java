public class A053_MaximumSubarray {
    public static void main(String[] args) {
        A053_MaximumSubarray maxSubarraySum = new A053_MaximumSubarray();
        int[] inputs = {-2,1,-3,4,-1,2,1,-5,4};
        int output = maxSubarraySum.maxSubArray(inputs);
        System.out.println(output);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        //dp[i] represents maximum subarray sum includes ith item
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < n; i++) {
            //if previous sum is greater than 0, add it to current sum
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            }
            //if previous sum is less than or equal to 0, throw them away
            else {
                dp[i] = nums[i];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
