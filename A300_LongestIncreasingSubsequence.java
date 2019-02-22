public class A300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        A300_LongestIncreasingSubsequence solution = new A300_LongestIncreasingSubsequence();
        int[] myInputs = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 8, 10, 12, 13, 16};
        int myResult = solution.lengthOfLIS(myInputs);
        System.out.println(myResult);
    }

    /** Solution 1: Binary Search O(nlgn) */
    /** reference: https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/ */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;

        /** store tails of each increasing subsequence with different length
         *eg: 3, 5, 1, 8, 2, 12
         * 1
         * 1, 2
         * 3, 5, 8
         * 3, 5, 8, 12
         * tails = {1, 2, 8, 12}
         * */

        /** we do not care about what elements are in each subsequence, we only care about tails of them,
         * because every time we only compare with their tails to decide which subsequence could we add new item
         * and update the entire structure */
        int[] tails = new int[nums.length];

        /**(1) if x is larger than all tails, append it, increase the size by 1
         * (2) if tails[i-1] < x <= tails[i], update tails[i] */
        for (int item : nums) {
            int left = 0, right = result;

            /** Use binary search to find the correct tail for new item
             *
             * KEY POINTS: find the smallest ceiling of every new number from the existed tails and replace that
             * ceiling number with new number
             *
             * CORNER CASE: if left = right at the first iteration, so do not need to worry about the tails array
             * does not have any items */
            while (left != right) {
                int mid = (left + right) / 2;

                if (tails[mid] < item) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }

            //update tails of current subsequence with length of left + 1
            tails[left] = item;

            //if updated subsequence is the longest one, increase result size by 1
            if (left == result) {
                result++;
            }
        }
        return result;
    }

    /** Solution 2: DP O(n^2)
     * sub-problem: dp[i] represents longest increasing subsequence from index 0 to i
     * base case: dp[i] = 1 for 0 < i < n - 1
     * recurrence relation: dp[i] = max(dp[i], dp[j] + 1) if nums[j] < nums[i], 0 < j < i
     * explanation: i - 1 is right boundary for current substring with length i, then we can have a moving pointer j,
     * scanning from 0 to i - 1, if nums[j] is less than i, then we can add nums[i] into increasing subsequence
     * between (0, i)
     * */
    public int lengthofLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int maxRes = 0;
        for (int i = 0; i < n; i++) {
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
    }
}
