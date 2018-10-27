import java.util.HashMap;
import java.util.Stack;

public class A032_LongestValidParentheses {
    public static void main(String[] args) {
        A032_LongestValidParentheses solution = new A032_LongestValidParentheses();
        String input = "())";
        int outpput = solution.longestValidParentheses(input);
        System.out.println(outpput);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //Step1: use a stack to store index all unmatched parentheses
        //eg: for the input ")()()(", stack will have ')', '(' finally
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            else {
                //does not care about matching left parentheses
                if (s.charAt(i) == '(') {
                    stack.push(i);
                }
                //if current character is ')'
                else {
                    //if matches top element in stack, pop top element
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }
                    //if does not match, push again
                    else {
                        stack.push(i);
                    }
                }
            }
        }

        //Step2: then count the longest distance between every two adjacent element in stack
        //because for the parentheses not in the stack, they are matched parentheses
        int result = 0;
        int bottom = 0, top = s.length();
        //if the entire string is valid (matched) parentheses
        if (stack.isEmpty()) {
            return top;
        }

        //iteratively calculate maximum gap value between every two adjacent unmatched parentheses
        while (!stack.isEmpty()) {
            bottom = stack.pop();
            //DO NOT FORGET to minus 1 at here
            result = Math.max(result, top - bottom - 1);
            top = bottom;
        }

        //DO NOT FORGET to deal with the last stack item
        result = Math.max(result, top);
        return result;
    }
}
