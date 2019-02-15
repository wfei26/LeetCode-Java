import java.util.HashMap;
import java.util.Map;

public class A594_LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        A594_LongestHarmoniousSubsequence solution = new A594_LongestHarmoniousSubsequence();
        int[] input = {1,2,5,2,3,3,2,5,6,1};
        int output = solution.findLHS(input);
        System.out.println(output);
    }


    /** brute force: O(n^2), optimized: O(n). The key point is that how we can use more space to decrease
     * time complexity so we can use a map to count frequency of each number, and then traverse the map,
     * to count the max frequency sum of every key and key + 1 */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxRes = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxRes = Math.max(maxRes, map.get(key) + map.get(key + 1));
            }
        }
        return maxRes;
    }
}
