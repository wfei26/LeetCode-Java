import java.util.Stack;

public class A224_BasicCalculator {
    public static void main(String[] args) {
        A224_BasicCalculator solution = new A224_BasicCalculator();
        String input = "(1+(4+5+2)-3)+(6+8)";
        int output = solution.calculate(input);
        System.out.println(output);
    }


    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int curNum = 0;
        //use sign to determine if operand is '+' or '-'
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            }
            else {
                if (c == '+') {
                    result += curNum * sign;
                    sign = 1;
                    curNum = 0;
                }
                else if (c == '-'){
                    result += curNum * sign;
                    sign = -1;
                    curNum = 0;
                }
                else if (c == '('){
                    //push current result firstly and then operand secondly
                    stack.push(result);
                    stack.push(sign);
                    //DO NOT FORGET to reset sign and result value since we already
                    //saved current result value, no need to add them later again
                    sign = 1;
                    result = 0;
                }
                else if (c == ')') {
                    result += sign * curNum;
                    curNum = 0;
                    //doing operation with previous operand before parentheses firstly
                    //then adding previous result secondly
                    result *= stack.pop();
                    result += stack.pop();
                }
            }
        }
        //DO NOT FORGET to add last item
        result += sign * curNum;
        return result;
    }
}
