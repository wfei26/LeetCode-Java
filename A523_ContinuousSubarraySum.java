import java.util.HashMap;
import java.util.Map;

public class A523_ContinuousSubarraySum {
    public static void main(String[] args) {
        A523_ContinuousSubarraySum solution = new A523_ContinuousSubarraySum();
        int[] myInputs = {0,0};
        int target = -1;
        boolean myResult = solution.checkSubarraySum(myInputs, target);
        System.out.println(myResult);
    }

    /** Key point: if we can find any two subarray of prefix sum with same mod value, then their difference MUST be
     * divisible by k. So we can use a map to store mod value of each prefix sum in map, with its index. Then check
     * if map contains the same mod value with size > 2 when we have new mod value in every iteration */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // corner case: if the very first subarray with first two numbers in array could form the result, we need to
        // put mod value 0 and index -1 to make it as a true case
        map.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            // corner case: k CANNOT be 0 when we use a number mod k
            if (k != 0) {
                curSum = curSum % k;
            }
            if (map.containsKey(curSum)) {
                if (i - map.get(curSum) > 1) {
                    return true;
                }
            }
            else {
                map.put(curSum, i);
            }
        }
        return false;
    }
}
