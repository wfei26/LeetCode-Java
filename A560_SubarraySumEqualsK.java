import java.util.HashMap;

public class A560_SubarraySumEqualsK {
    public static void main(String[] args) {
        A560_SubarraySumEqualsK solution = new A560_SubarraySumEqualsK();
        int[] myInput = {1,1,1};
        int target = 2;
        int myResult = solution.subarraySum(myInput, target);
        System.out.println(myResult);
    }

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
