public class A698_PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        A698_PartitionToKEqualSumSubsets solution = new A698_PartitionToKEqualSumSubsets();
        int[] input = {4, 3, 2, 3, 5, 2, 1};
        boolean output = solution.canPartitionKSubsets(input, 4);
        System.out.println(output);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean result = partitionHelper(nums, k, sum / k, 0, new boolean[nums.length], 0);
        return result;
    }

    public boolean partitionHelper(int[] nums, int k, int target, int curSum, boolean[] visited, int start) {
        // first recursion exit: when we successfully partition the array to k - 1 subsets, then the last subset will also be valid
        // since we already checked before calling dfs function
        if (k == 1) {
            return true;
        }

        // second recursion exit: when we find a valid subset, k-- and reset curSum to start finding other subsets
        if (curSum == target) {
            return partitionHelper(nums, k - 1, target, 0, visited, 0);
        }

        // recursive step
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                // third recursion exit: update curSum, and keep finding the rest of numbers of candidate subset
                if (partitionHelper(nums, k, target, curSum + nums[i], visited, i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        // if the function never go to the recursion exit, result false
        return false;
    }
}
