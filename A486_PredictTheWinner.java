public class A486_PredictTheWinner {
    public static void main(String[] args) {
        A486_PredictTheWinner solution = new A486_PredictTheWinner();
        int[] input = {1,5,233,7};
        boolean output = solution.PredictTheWinner2(input);
        System.out.println(output);
    }

    /** solution 1: dp[i][j] represents the extra profit you are more than your opponent in the range i to j
     * if dp[i][j] is negative, it means your opponent will have more profit than yours between i to j
     * */
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int n = nums.length;
        // sub-problem: dp[i][j] represents max profit of CURRENT player
        int[][] dp = new int[n][n];

        // base case: if we only have one number, which means from range i to i, then the max profit is nums[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // we fill dp table by window size, start from 1 to n: hold an size, traverse every subarray with same size
        // from left to right, and then calculate dp value for every subarray
        for (int size = 1; size < n; size++) {
            for (int left = 0; left < n - size; left++) {
                int right = left + size;
                /**
                 * recurrence relation: we have two options, choose from left or choose from right,
                 * we need to choose the one with max profit.
                 * dp[i + 1][j] or dp[j][j + 1] represents the profit difference between your opponent and you
                 * eg: is dp[i + 1][j] is positive, it means your opponent can have more profit than you from range i + 1 to j
                 * if dp[i + 1][j] is negative, is means you have more profit than your opponent from range i + 1 to j
                 * dp[i][j - 1] has similar meaning.
                 * */
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right], nums[right] - dp[left][right - 1]);
            }
        }
        // return: if profit between 0 to n - 1 is greater than or equal to 0, you win
        return dp[0][n - 1] >= 0;
    }

    /** solution 2: dp[i][j] represents max profit of CURRENT player can get from i to j
     * dp[i][j] can be the status of either player, it depends on which round you are in, dp[i][j] represents
     * your max profit between i to j, then dp[i][j - 1] or dp[i + 1][j] represents your opponent's max profit
     * */
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // base case: if we only have one number, which means from range i to i, then the max profit is nums[i]
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // we fill dp table by window size, start from 1 to n: hold an size, traverse every subarray with same size
        // from left to right, and then calculate dp value for every subarray
        for (int size = 1; size < n; size++) {
            for (int left = 0; left < n - size; left++) {
                int right = left + size;
                dp[left][right] = Math.max(nums[left] + Math.min(dp[left + 2][right], dp[left + 1][right - 1]),
                        nums[right] + Math.min(dp[left + 1][right - 1], dp[left][right - 2]));
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
