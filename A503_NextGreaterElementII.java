import java.util.Arrays;
import java.util.Stack;

public class A503_NextGreaterElementII {
    public static void main(String[] args) {
        A503_NextGreaterElementII solution = new A503_NextGreaterElementII();
        int[] myInputs = {1,3,4,2};
        int[] myResults = solution.nextGreaterElements(myInputs);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] results = new int[n];
        Arrays.fill(results, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int target = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < target) {
                results[stack.pop()] = target;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return results;
    }
}
