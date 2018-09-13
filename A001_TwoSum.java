import java.util.HashMap;

public class A001_TwoSum {
    public static void main(String[] args) {
        A001_TwoSum solution = new A001_TwoSum();
        int[] myInputs = {2,7,11,15};
        int target = 9;
        int[] myResults = solution.twoSum(myInputs, target);
        System.out.println(myResults[0]);
        System.out.println(myResults[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            }
            else {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}
