import java.util.HashMap;
import java.util.Map;

public class A532_KDiffPairsInAnArray {
    public static void main(String[] args) {
        A532_KDiffPairsInAnArray solution = new A532_KDiffPairsInAnArray();
        int[] myInputs = {1,2,3,4,5,6};
        int k = 1;
        int myResult = solution.findPairs(myInputs, k);
        System.out.println(myResult);
    }

    /**
     * use a map to deduplicate and count frequency as well
     * we count frequency is because when k is equal 0, we need to find all elements that have two or more identical
     * number in the array
     * */
    public int findPairs(int[] nums, int k) {
        // corner case: check whether k is less than 0
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    result++;
                }
            }
            // similar to two sum, but we only use smaller number plus k to get the greater number, to make sure
            // we only count once for a pair of numbers
            else {
                if (map.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }
        return result;
    }
}
