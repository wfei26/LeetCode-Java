import java.util.HashMap;

public class A325_MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        A325_MaximumSizeSubarraySumEqualsK solution = new A325_MaximumSizeSubarraySumEqualsK();
        int[] myInputs = {4,8,0,-2,5,2,-8,7,1,-4,4,8,-2,5,-5,-2,8};
        int target = 0;
        int myResult = solution.maxSubArrayLen(myInputs, target);
        System.out.println(myResult);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result = Math.max(result, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return result;
    }
}
