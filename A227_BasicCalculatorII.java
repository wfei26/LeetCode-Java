import java.util.Stack;

public class A227_BasicCalculatorII {
    public static void main(String[] args) {
        A227_BasicCalculatorII solution = new A227_BasicCalculatorII();
        String input = "3+2*3";
        int output = solution.calculate(input);
        System.out.println(output);
    }

    /**
     * Key point: we only do multiplication and division in every iteration, then push every number into stack with
     * calculation result. Adding every calculation result in stack to and finally accumulate to get final result.
     * */
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int curNum = 0;
        // initialize sign as '+' since we do not have any negative numbers in the input
        // virtually adding a '+' before the input string. eg: 3+2*3 -> actually execute +3+2*3
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            else if (Character.isDigit(s.charAt(i))) {
                curNum = curNum * 10 + (s.charAt(i) - '0');
            }
            else {
                stackOperation(stack, sign, curNum);
                // mark next sign, and then read next number, then doing calculation for next sign and next number
                sign = s.charAt(i);
                curNum = 0;
            }
        }

        // WARNING: DO NOT FORGET to the last operation
        stackOperation(stack, sign, curNum);
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public void stackOperation(Stack<Integer> stack, char sign, int curNum) {
        // push positive number
        if (sign == '+') {
            stack.push(curNum);
        }
        // push negative number
        else if (sign == '-') {
            stack.push(-curNum);
        }
        // calculate multiplication value
        else if (sign == '*') {
            stack.push(curNum * stack.pop());
        }
        // calculate dividing value
        else if (sign == '/') {
            stack.push(stack.pop() / curNum);
        }
    }
}
