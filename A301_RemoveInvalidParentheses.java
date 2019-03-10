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

    /** count number of unmatched left parentheses and unmatched right parentheses. Then use dfs recursion to try to
     * delete every possible index to generate a new string, and then check if new string is valid string */
    public List<String> removeInvalidParentheses(String s) {
        int leftUnmatch = 0;
        int rightUnmatch = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftUnmatch++;
            }
            else if (c == ')') {
                if (leftUnmatch == 0) {
                    rightUnmatch++;
                }
                else {
                    leftUnmatch--;
                }
            }
        }

        System.out.println(leftUnmatch + " " + rightUnmatch);
        List<String> result = new ArrayList<>();
        dfs(result, s, leftUnmatch, rightUnmatch, 0);
        return result;
    }

    private void dfs(List<String> result, String s, int leftUnmatch, int rightUnmatch, int index) {
        // recursion exit: if both of left and right unmatched parentheses have been matched, and current string is
        // a valid parentheses string, it is a correct candidate
        if (leftUnmatch == 0 && rightUnmatch == 0 && isValid(s)) {
            result.add(s);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            // delete current character to form a new string
            String tempStr = s.substring(0, i) + s.substring(i + 1);

            // if we still have quota for deleting left parentheses or right parentheses, try next dfs recursion
            if (leftUnmatch > 0 && s.charAt(i) == '(') {
                // since we already -1 for next recursion index, we DO NOT need  to use i+1 as parameter for next recursion
                dfs(result, tempStr, leftUnmatch - 1, rightUnmatch, i);
            }
            else if (rightUnmatch > 0 && s.charAt(i) == ')') {
                dfs(result, tempStr, leftUnmatch, rightUnmatch - 1, i);
            }
        }
    }

    private boolean isValid(String s) {
        int match = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                match++;
            }
            else if (c == ')') {
                if (match == 0) {
                    return false;
                }
                else {
                    match--;
                }
            }
        }
        return match == 0;
    }
}
