import java.util.HashMap;

public class A128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        A128_LongestConsecutiveSequence solution = new A128_LongestConsecutiveSequence();
        int[] myInputs = {100, 4, 200, 1, 3, 2, 5};
        int myResult = solution.longestConsecutive(myInputs);
        System.out.println(myResult);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            if (map.containsKey(nums[i])) {
                continue;
            }
            else {
                if (map.containsKey(nums[i] - 1)) {
                    left = map.get(nums[i] - 1);
                }
                if (map.containsKey(nums[i] + 1)) {
                    right = map.get(nums[i] + 1);
                }
                int sum = left + right + 1;
                result = Math.max(result, sum);
                map.put(nums[i], sum);
                map.put(nums[i] - left, sum);
                map.put(nums[i] + right, sum);
            }
        }
        return result;
    }
}
