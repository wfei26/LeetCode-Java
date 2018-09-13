public class A209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        A209_MinimumSizeSubarraySum solution = new A209_MinimumSizeSubarraySum();
        int[] myInputs = {2,3,1,2,4,3};
        int target = 7;
        int myResult = solution.minSubArrayLen(target, myInputs);
        System.out.println(myResult);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                result = Math.min(result, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        else {
            return result;
        }
    }
}
