public class A921_MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        A921_MinimumAddToMakeParenthesesValid solution = new A921_MinimumAddToMakeParenthesesValid();
        String input = "()))((";
        int output = solution.minAddToMakeValid(input);
        System.out.println(output);
    }

    /** If we use stack to do this problem, the only character we need to put into stack is '('. So we could
     * use a constant variable instead of stack, to count how many '(' we have until each iteration.
     * 1. if we see '(', count++
     * 2. if we see ')', but count is equal to 0, result++ since we need an extra '(' to match ')'
     * 3. if we see ')', but count is not equal to 0, count-- since we matched a pair of bracket */
    public int minAddToMakeValid(String S) {
        if (S.length() == 0) {
            return 0;
        }

        int result = 0;
        int countLeft = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                countLeft++;
            }
            else if (c == ')') {
                if (countLeft == 0) {
                    result++;
                }
                else {
                    countLeft--;
                }
            }
        }
        // WARNING: DO NOT FORGET to match the rest of '(' after traversing the entire string
        result += countLeft;
        return result;
    }
}
