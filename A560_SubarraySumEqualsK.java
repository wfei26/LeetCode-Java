import java.util.HashMap;

public class A560_SubarraySumEqualsK {
    public static void main(String[] args) {
        A560_SubarraySumEqualsK solution = new A560_SubarraySumEqualsK();
        int[] myInput = {1,1,-1,1,-1,1,1};
        int target = 2;
        int myResult = solution.subarraySum(myInput, target);
        System.out.println(myResult);
    }

    /** Use a hash map to store preSum and its frequency, if map contains key of current preSum - k, then the original
     * array must contain a subarray sum equals k */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int preSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // corner case: if the very first subarray that start from index 0 has preSum equals k, we will have to check
        // whether we have key (preSum - k = 0), so must put(0, 1) as pre-processing, since this case is considered a
        // valid case, we must add count value 1 to result
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                // count of subarray that have prefix sum equals preSum - k, add count to result
                result += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}
