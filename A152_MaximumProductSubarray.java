public class A152_MaximumProductSubarray {
    public static void main(String[] args) {
        A152_MaximumProductSubarray solution = new A152_MaximumProductSubarray();
        int[] myInputs = {2,3,-2,4};
        int myResult = solution.maxProduct(myInputs);
        System.out.println(myResult);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        int preMax = 0, preMin = 0;
        int curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = curMax;
            preMin = curMin;
            curMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin*nums[i]));
            result = Math.max(result, curMax);
        }
        return result;
    }
}
