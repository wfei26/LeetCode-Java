import java.util.Stack;

public class A739_DailyTemperatures {
    public static void main(String[] args) {
        A739_DailyTemperatures solution = new A739_DailyTemperatures();
        int[] input = {73,74,75,71,69,72,76,73};
        int[] output = solution.dailyTemperatures(input);
        for (int day : output) {
            System.out.println(day);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];

        // maintain a monotone decreasing stack, to store index of each item
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // if stack is not empty and new temperature is higher than top element in stack
            // calculate difference between index of current temp and index of top stack element
            // the current calculation result will be number of days of next greater temperature
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
