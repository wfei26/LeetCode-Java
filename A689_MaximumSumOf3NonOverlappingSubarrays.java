public class A689_MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        A689_MaximumSumOf3NonOverlappingSubarrays solution = new A689_MaximumSumOf3NonOverlappingSubarrays();
        int[] inputs = {1,2,1,2,6,7,5,1};
        int size = 2;
        int[] outputs = solution.maxSumOfThreeSubarrays(inputs, size);
        System.out.println(outputs[0]);
        System.out.println(outputs[1]);
        System.out.println(outputs[2]);
    }

    /**
     * High level: calculate left local max subarray with size k from left to right and right local max subarray
     * with size k from right to left. And use sliding window to do 3-sum from left to right
     *
     * Step 1: calculate prefix sum dp array
     * Step 2: calculate left local max subarray with size k
     * dp1: leftMaxPos[i] represents max subarray STARTING index with size k starting from i in the range [0, i - k]
     * dp2: rightMaxPos[i] represents max subarray STARTING index with siz k starting from i in the range [i, n - 1]
     *
     * Step 3: traverse from k to n - 2k, keep a window with size k, calculate "3sum" in every iteration, and return
     * the max one.
     * eg: for index i, we have max subarray starting index (leftMaxPos[i - 1]) on the left side of current window,
     * we also have max subarray starting index (rightMaxPos[i + k]) on the right side of current window. Then we are
     * able to find max 3sum by traversing all possible 3sums
     * */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] results = new int[3];
        if (nums == null || nums.length == 0 || k == 0) {
            return results;
        }

        int n = nums.length;
        int[] preSum = new int[n];

        // preSum array saves prefix sum include current index
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        // leftPosMax[i] saves the STARTING index of max partial sum with length k for the left interval in range [0, i]
        // rightPosMax[i] saves the STARTING index max partial sum with length k for the right interval in range [i, n-1]
        int[] leftMaxPos = new int[n], rightMaxPos = new int[n];

        // traverse from k to right, dynamically calculate starting index of max k sum in previous ith items
        int partialMax = preSum[k - 1];
        for (int i = k; i < n; i++) {
            int curLeftKSum = preSum[i] - preSum[i - k];
            if (curLeftKSum > partialMax) {
                leftMaxPos[i] = i - k + 1;
                partialMax = curLeftKSum;
            }
            else {
                leftMaxPos[i] = leftMaxPos[i - 1];
            }
        }


        //traverse from right - k + 1 to left, dynamically calculate starting index of max k sum in last ith items
        partialMax = 0;
        for (int i = n - k; i >= 0; i--) {
            // WARNING: in order to avoid array out of bound error, we cannot use preSum[i+k-1] - preSum[i-1]
            int curRightKSum = preSum[i + k - 1] - preSum[i] + nums[i];

            // WARNING: in order to get lexicographical order, when there are two intervals with equal max sum, always
            // select the left most one. So we use ">=" if we traverse from right to left (if equal, select left one)
            // If traverse from left to right, just use ">" in the if-statement, since we do not need to replace the
            // right one if we find another equal value from the right part.
            if (curRightKSum >= partialMax) {
                rightMaxPos[i] = i;
                partialMax = curRightKSum;
            }
            else {
                rightMaxPos[i] = rightMaxPos[i + 1];
            }
        }

        //traverse from k to n - 2k, dynamically calculate max 3 sum with leftPart + middlePart + rightPart
        int maxSum = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            //saves current left max index and current right max index in current ith position
            int curLeftMaxPos = leftMaxPos[i - 1], curRightMaxPos = rightMaxPos[i + k];

            //calculate current max 3 sum (left + middle + right)
            //for the left part, be careful the error of array out of bound (use ... + nums[curLeftMaxPos])
            int cur3Sum = (preSum[curLeftMaxPos + k - 1] - preSum[curLeftMaxPos] + nums[curLeftMaxPos])
                        + (preSum[i + k - 1] - preSum[i - 1])
                        + (preSum[curRightMaxPos + k - 1] - preSum[curRightMaxPos - 1]);
            //if current 3 sum is greater than previous max sum, update max sum value and results array
            if (cur3Sum > maxSum) {
                maxSum = cur3Sum;
                results[0] = curLeftMaxPos;
                results[1] = i;
                results[2] = curRightMaxPos;
            }
        }
        return results;
    }
}
