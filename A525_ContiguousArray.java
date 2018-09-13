import java.util.HashMap;

public class A525_ContiguousArray {
    public static void main(String[] args) {
        A525_ContiguousArray solution = new A525_ContiguousArray();
        int[] myInputs = {0,1,0};
        int myResult = solution.findMaxLength(myInputs);
        System.out.println(myResult);
    }

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        return result;
    }
}
