public class A713_SubarrayProductLessThanK {
    public static void main(String[] args) {
        A713_SubarrayProductLessThanK solution = new A713_SubarrayProductLessThanK();
        int[] myInputs = {10, 5, 2, 6};
        int target = 100;
        int myResult = solution.numSubarrayProductLessThanK(myInputs, target);
        System.out.println(myResult);
    }

    /** Maintain a sliding window that have product less than 100, iteratively adding number of valid subarray into result */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // corner case: when k == 0, return 0 directly since we do not have negative numbers in array
        if (nums.length == 0 || k == 0) {
            return 0;
        }
        int result = 0;
        int product = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            // while product in current window is over than limit, remove most left number and move left pointer
            // WARNING: MUST use "while" to move left side of window, NOT "if"
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            // add count of new subarray include current number nums[j] to result
            result += j - i + 1;
        }
        return result;
    }
}
