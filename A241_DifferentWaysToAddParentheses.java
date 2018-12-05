import java.util.ArrayList;
import java.util.List;

public class A241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        A241_DifferentWaysToAddParentheses solution = new A241_DifferentWaysToAddParentheses();
        String input = "2*3-4*5";
        List<Integer> output = solution.diffWaysToCompute(input);
        for (int item : output) {
            System.out.println(item);
        }
    }

    // Divide and Conquer
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();

        // divide input string into two substrings by operand until they are all separated as single numbers
        // then recursively make operations (+, -, *) for each results, and then combine them together
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                for (int leftRes : leftResults) {
                    for (int rightRes : rightResults) {
                        int calRes = 0;
                        if (input.charAt(i) == '+') {
                            calRes = leftRes + rightRes;
                        }
                        else if (input.charAt(i) == '-') {
                            calRes = leftRes - rightRes;
                        }
                        else if (input.charAt(i) == '*') {
                            calRes = leftRes * rightRes;
                        }
                        results.add(calRes);
                    }
                }
            }
        }

        // DO NOT FORGET the last step: when input does not contain any operands
        // we need to add the single number to the result list.
        // It is also the minimum units of Divide and Conquer
        if (results.size() == 0) {
            results.add(Integer.valueOf(input));
        }
        return results;
    }
}
