import java.util.Stack;

public class A227_BasicCalculatorII {
    public static void main(String[] args) {
        A227_BasicCalculatorII solution = new A227_BasicCalculatorII();
        String input = "3+2*3-6/2";
        int output = solution.calculate(input);
        System.out.println(output);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int curNum = 0;
        char sign = '+';

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curNum += curNum * 10 + (c - '0');
            }
            else {
                if (sign == '+') {

                }
                else if (sign == '-') {

                }
                else if (sign == '*') {

                }
                else if (sign == '/') {

                }
                sign = c;
                curNum = 0;
            }
        }
    }
}
