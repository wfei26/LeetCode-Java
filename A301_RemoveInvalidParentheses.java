import java.util.ArrayList;
import java.util.List;

public class A301_RemoveInvalidParentheses {
    public static void main(String[] args) {
        A301_RemoveInvalidParentheses solution = new A301_RemoveInvalidParentheses();
        String input = "(a)())()";
        List<String> output = solution.removeInvalidParentheses(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        if (s == null) {
            return results;
        }

        // count how many invalid parentheses we need to remove
        int numOfLeft = 0;
        int numOfRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                numOfLeft++;
            }
            else if (c == ')') {
                // case: we have ")" without any "(" before it
                if (numOfLeft == 0) {
                    numOfRight++;
                }
                else {
                    numOfLeft--;
                }
            }
        }

        dfs(results, s, numOfLeft, numOfRight, 0);
        return results;
    }

    public void dfs(List<String> results, String s, int leftCount, int rightCount, int index) {
        // recursion exit: if all invalid left and right parentheses have already been removed
        if (leftCount == 0 && rightCount == 0 && isValid(s)) {
            results.add(s);
            return;
        }


        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // deduplicate if we have "((((("
                if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }

                // remove current character and try dfs for the rest of string
                String tempStr = s.substring(0, i) + s.substring(i + 1);

                // DO NOT FORGET to determine value of leftCount and rightCount, since we need to know
                // if we still have invalid parentheses left after current recursive step

                // pruning: it is not possible for leftCount == 0 && rightCount == 0 at here
                // but may have the condition if leftCount == 0 || rightCount == 0
                // so we can check the leftCount and rightCount condition to prune
                if (leftCount > 0 && s.charAt(i) == '(') {
                    dfs(results, tempStr, leftCount - 1, rightCount, i);
                }
                else if (rightCount > 0 && s.charAt(i) == ')') {
                    dfs(results, tempStr, leftCount, rightCount - 1, i);
                }
            }
        }
    }


    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
            }
            // corner case: ")("
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
