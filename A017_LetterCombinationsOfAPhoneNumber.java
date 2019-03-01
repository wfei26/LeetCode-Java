import java.util.ArrayList;
import java.util.List;

public class A017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        A017_LetterCombinationsOfAPhoneNumber solution = new A017_LetterCombinationsOfAPhoneNumber();
        String input = "23";
        List<String> myResult = solution.letterCombinations(input);
        for (int i = 0; i < myResult.size(); i++) {
            System.out.println(myResult.get(i));
        }
    }

    final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        dfs(result, digits, 0, "");
        return result;
    }

    /** Get index of letters array by getting every single digit of digits string, maintain a prefix string, traverse all
     * characters of string on the corresponding index of letters and append to prefix string that we already built in previous
     * recursions */
    public void dfs(List<String> result, String digits, int pos, String prefix) {
        if (pos == digits.length()) {
            result.add(prefix);
            return;
        }

        String candidates = letters[digits.charAt(pos) - '0'];
        for (int i = 0; i < candidates.length(); i++) {
            dfs(result, digits, pos + 1, prefix + candidates.charAt(i));
        }
    }
}
