import java.util.ArrayList;
import java.util.List;

public class A784_LetterCasePermutation {
    public static void main(String[] args) {
        A784_LetterCasePermutation solution = new A784_LetterCasePermutation();
        String input = "a1b2";
        List<String> output = solution.letterCasePermutation(input);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> results = new ArrayList<>();
        if (S.length() == 0) {
            results.add("");
            return results;
        }

        backtracking(results, S.toCharArray(), 0);
        return results;
    }

    public void backtracking(List<String> results, char[] S, int index) {
        // recursion exit: when index equals to string length -> out of bound -> add current string to results
        if (index == S.length) {
            results.add(new String(S));
            return;
        }

        // if current character is digit -> skip and go to next recursion
        if (Character.isDigit(S[index])) {
            backtracking(results, S, index + 1);
            return;
        }

        // try lower case
        // eg: for the case a1b2, try b. When index reach to string length, return after adding to results
        // and go back to isDigit recursive call, return again, then go back to here to try Upper case of B next
        S[index] = Character.toLowerCase(S[index]);
        backtracking(results, S, index + 1);

        // try upper case
        S[index] = Character.toUpperCase(S[index]);
        backtracking(results, S, index + 1);
    }
}
