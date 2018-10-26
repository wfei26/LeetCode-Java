import java.util.HashMap;
import java.util.List;

public class A219_ContainsDuplicateII {
    public static void main(String[] args) {
        A219_ContainsDuplicateII checker = new A219_ContainsDuplicateII();
        int[] inputs = {1,2,3,1,2,3};
        boolean output = checker.containsNearbyDuplicate(inputs, 2);
        System.out.println(output);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
