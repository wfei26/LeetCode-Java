import java.util.Stack;

public class A962_MaximumWidthRamp {
    public static void main(String[] args) {
        A962_MaximumWidthRamp solution = new A962_MaximumWidthRamp();
        int[] input = {6,0,8,2,1,5};
        int output = solution.maxWidthRamp(input);
        System.out.println(output);
    }

    public int maxWidthRamp(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        // build a monotonic decreasing stack from the input array (bottom -> top: decreasing)
        // WARNING: MUST store index instead of storing values, since we want to calculate index difference
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }

        int result = 0;
        // traverse the original array from right to left, iteratively calculate max width between two indices
        for (int i = A.length - 1; i >= 0; i--){
            // if current right most element is greater than top element of stack, calculate index difference between them,
            // and keep popping element from stack until top element of stack is greater than current right most element
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }
        return result;
    }
}
