import java.util.HashMap;

public class A523_ContinuousSubarraySum {
    public static void main(String[] args) {
        A523_ContinuousSubarraySum solution = new A523_ContinuousSubarraySum();
        int[] myInputs = {0,0};
        int target = -1;
        boolean myResult = solution.checkSubarraySum(myInputs, target);
        System.out.println(myResult);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            }
            else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
