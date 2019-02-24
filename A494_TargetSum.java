public class A494_TargetSum {
    public static void main(String[] args) {
        A494_TargetSum solution = new A494_TargetSum();
        int[] input = {1,1,1,1,1};
        int output = solution.findTargetSumWays2(input, 3);
        System.out.println(output);
    }


    /** solution 1: DFS - Time: O(2^n), Space: O(n^2) */
    int result = 0;
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        dfs(nums, S, 0, 0);
        return result;
    }

    public void dfs(int[] nums, int target, int calcVal, int pos) {
        if (pos == nums.length) {
            if (calcVal == target) {
                result++;
            }
            return;
        }
        dfs(nums, target, calcVal + nums[pos], pos + 1);
        dfs(nums, target, calcVal - nums[pos], pos + 1);
    }


    /** solution 2: DP (0/1 knapsack) - Time: O(n^2), Space: O(n^2) */
    /**
     * sub-problem: dp[i][j] represents number of possible ways to reach sum j by using first ith items
     * base case: dp[0][sum], position sum represents sum 0
     * recurrence relation:
     * dp[i][j] += dp[i - 1][i + nums[i - 1]] if j + nums[i - 1] <= sum * 2
     * dp[i][j] += dp[i - 1][i - nums[i - 1]] if j - nums[i - 1] >= 0
     *
     * explanation: if j + nums[i - 1] or j - nums[i - 1] is in correct range, we can use the number nums[i - 1]
     * to generate next state of dp array
     * */
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // corner case: when S is out of range [-sum, sum]
        if (S < -sum || S > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        int leftBound = 0;
        int rightBound = sum * 2;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = leftBound; j < rightBound + 1; j++) {
                // try all possible sum of (previous sum j + current number nums[i - 1]) and all possible difference of
                // (previous sum j - current number nums[i - 1])
                if (j + nums[i - 1] <= rightBound) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
                if (j - nums[i - 1] >= leftBound) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + S];
    }


    /** solution 3: DP - Time: O(n^2), Space: O(n) */
    /**
     * if we calculate total sum of all candidate numbers, then the range of possible calculation result will be in
     * the range [-sum, sum]. So we can define an dp array with size sum * 2 + 1 to calculate number of possible ways
     * to reach every target value between -sum to sum, and save results to dp array. dp[sum + S] will be out final
     * result. (because dp[sum] or less represents number of possible ways to reach a number in range [-sum, 0])
     *
     * sub-problem: dp[i] represents number of possible ways to reach target i
     * base case: dp[sum] = 1  //if we add all numbers
     * recurrence relation: when doing inner loop iterations, we should create another temp dp array to store temp
     * target array. Because if we use dp array to store temp results directly, we may have array boundary exception
     * eg: for input [1,1,1,1,1], we will never reach dp[6] or d[-6]. However, if we use dp[j + nums[i]] to store
     * temp results, we may proceed dp[5 + 1] += dp[5], which is considered incorrect case
     * */
    public int findTargetSumWays3(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
           sum += num;
        }

        // corner case: when S is out of range [-sum, sum]
        if (S < -sum || S > sum) {
            return 0;
        }

        int[] dp = new int[sum * 2 + 1];
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] tempTarget = new int[sum * 2 + 1];
            for (int j = 0; j < sum * 2 + 1; j++) {
                // WARNING: DO NOT FORGET to check condition whether dp[i] is 0 or not
                // if it is NOT 0, it means we at least have one possible way to reach target j. Otherwise, we may have
                // array out of bound exception
                if (dp[j] != 0) {
                    tempTarget[j + nums[i]] += dp[j];
                    tempTarget[j - nums[i]] += dp[j];
                }
            }
            dp = tempTarget;
        }
        return dp[sum + S];
    }
}
