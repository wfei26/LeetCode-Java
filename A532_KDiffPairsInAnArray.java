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

    public int findPairs(int[] nums, int k) {
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
            else {
                if (map.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }
        return result;
    }
}
