public class A918_MaximumSumCircularSubarray {
    public static void main(String[] args) {
        A918_MaximumSumCircularSubarray solution = new A918_MaximumSumCircularSubarray();
        int[] input = {3,-1,2,-1};
        int output = solution.maxSubarraySumCircular(input);
        System.out.println(output);
    }

    /**
     * we have two different cases:
     * 1. max subarray is not circular: we can easily calculate maximum subarray sum
     * 2. max subarray is circular: we can calculate minimum subarray sum and total array sum, and then
     * find difference between total sum and minimum subarray sum
     * eg: |++++++maxSubarray+++++ | ---------minSubarray--------- | ++++maxSubarray++++|
     * */
    public int maxSubarraySumCircular(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        /**
         * @param totalSum: total subarray sum
         * @param curMax: current max subarray sum
         * @param maxSum: globe max Sum, update when we find a new subarray with greater sum
         * @param curMin: current min subarray sum
         * @param minSum: globe min Sum, update when we find a new subarray with smaller sum
         * */
        int totalSum = 0;
        int curMax = 0, curMin = 0;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            // if new element is greater than previous subarray sum, drop the entire previous subarray
            curMax = Math.max(curMax + A[i], A[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + A[i], A[i]);
            minSum = Math.min(minSum, curMin);

            totalSum += A[i];
        }

        // corner case: when array is all negative numbers
        if (maxSum < 0) {
            return maxSum;
        }
        // return the max value of two conditions
        return Math.max(maxSum, totalSum - minSum);
    }
}
