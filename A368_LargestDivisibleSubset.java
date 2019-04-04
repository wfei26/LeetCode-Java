import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A368_LargestDivisibleSubset {
    public static void main(String[] args) {
        A368_LargestDivisibleSubset solution = new A368_LargestDivisibleSubset();
        int[] nums = {1,2,3};
        List<Integer> res = solution.largestDivisibleSubset(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }

    /** Sort the array, then use a dp array and another parentIndex array to store processed information:
     * Sub-problem: dp[i] represents longest sub-sequence that satisfies mod requirements
     * Base case: dp[0] = 1
     * Recurrence relation: dp[i] = Math.max(dp[j] + 1, dp[i]), 0 <= j <= i - 1 */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] preIndex = new int[n];
        int maxSize = 0;
        int maxIndex = -1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            // initialize parent of current value to -1
            preIndex[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    // if we have longer sequence, update current dp value and parent array
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        preIndex[i] = j;
                    }
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // traverse all numbers until reach the ancestor of longest sequence
        List<Integer> result = new ArrayList<>();
        int curIndex = maxIndex;
        while (curIndex != -1) {
            result.add(nums[curIndex]);
            curIndex = preIndex[curIndex];
        }
        return result;
    }
}
