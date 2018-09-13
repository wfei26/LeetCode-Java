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

        int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE;
        int i = 0, j = -1;
        for (int left = 0, right = nums.length - 1; left < nums.length; left++, right--) {
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[left]);
            //if the current max value of first left element is not from current value,
            //it means the current value need to sort
            if (curMax != nums[left]) {
                i = right;
            }
            //if the current min value of last right element is not from current value,
            //it means the current value need to sort
            if (curMin != nums[right]) {
                j = left;
            }
        }
        return j - i + 1;
    }
}
