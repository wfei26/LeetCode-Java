public class A678_ValidParenthesisString {
    public static void main(String[] args) {
        A678_ValidParenthesisString solution = new A678_ValidParenthesisString();
        String input = "(*))";
        boolean output = solution.checkValidString(input);
        System.out.println(output);
    }

    // The overall idea is kind of DFS with pruning. We tried every possible case that can make count to 0,
    // but cut off some invalid path in the middle steps. Scan from left to right, and record counts of
    // unpaired ‘(’ for all possible cases. For ‘(’ and ‘)’, it is straightforward, just increment and
    // decrement all counts, respectively. When the character is '*', there are three cases, ‘(’, empty, or ‘)’,
    // we can think those three cases as three branches in the ongoing route.
    public boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }

        // lowerBound represents minimum number of '(' we need to match
        // higherBound represents maximum number of '(' we need to match
        int lowerBound = 0, upperBound = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lowerBound++;
                upperBound++;
            }
            else if (c == ')') {
                // pruning: if lower bound is negative, it means we have more ')' than '(', which is invalid
                if (lowerBound > 0) {
                    lowerBound--;
                }
                upperBound--;
            }
            // when c is *, we have three possibilities: '(', ')', empty
            // if * counts as '(', higherBound++
            // if * counts as ')', lowerBound-- if it is greater than 0
            // if * counts as empty, it does not affect lowerBound and upperBound
            else {
                if (lowerBound > 0) {
                    lowerBound--;
                }
                upperBound++;
            }

            // if we cannot find any paths that have enough '*' and ')' to match traversed '(', the string until
            // current index has already been invalid, the  we do not need to check the rest of string
            if (upperBound < 0) {
                return false;
            }
        }
        // if we find a path that matches all '(' and ')', return true; otherwise, return false
        return lowerBound == 0;
    }
}
