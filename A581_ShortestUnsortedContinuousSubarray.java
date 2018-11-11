public class A581_ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        A581_ShortestUnsortedContinuousSubarray solution = new A581_ShortestUnsortedContinuousSubarray();
        int[] myInputs = {2, 6, 4, 8, 10, 9, 15};
        int myResult = solution.findUnsortedSubarray(myInputs);
        System.out.println(myResult);
    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //CAUTION: we need to initialize j as -1, since we will return j - i + 1
        //eg: if original array is well sorted, then we will return -1 - 0 + 1 = 0
        int left = 0, right = -1;

        int curMax = Integer.MIN_VALUE;
        //traverse from left to right, and then update curMax value if necessary
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, nums[i]);
            //if the current max value is not from current value,
            //it means the current value need to sort, and put in another correct position
            if (curMax != nums[i]) {
                right = i;
            }
        }

        int curMin = Integer.MAX_VALUE;
        //traverse from right to left, and then update curMin value if necessary
        for (int i = nums.length - 1; i >= 0; i--) {
            curMin = Math.min(curMin, nums[i]);
            //if the current min value is not from current value,
            //it means the current value need to sort, and put in another correct position
            if (curMin != nums[i]) {
                left = i;
            }
        }
        return right - left + 1;
    }
}
