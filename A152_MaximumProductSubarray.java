public class A152_MaximumProductSubarray {
    public static void main(String[] args) {
        A152_MaximumProductSubarray solution = new A152_MaximumProductSubarray();
        int[] myInputs = {-2};
        int myResult = solution.maxProduct(myInputs);
        System.out.println(myResult);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //CAUTION: MUST initialize result as nums[0], just in case if nums only contains
        //one element, then it will not enter the loop below
        int result = nums[0];
        int preMin = 0, preMax = 0;
        int curMin = nums[0], curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = curMax;
            preMin = curMin;

            //since we have negative number in the array, we need to calculate both of
            //max product and min product in every iteration, so that we will not miss
            //any max number with product of two greater negative number
            //CAUTION: for curMax and curMin, we compare with nums[i], not compare with
            //curMax and curMin itself
            curMax = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            result = Math.max(result, curMax);
        }
        return result;
    }
}
