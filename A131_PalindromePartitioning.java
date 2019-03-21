import java.util.ArrayList;
import java.util.List;

public class A131_PalindromePartitioning {
    public static void main(String[] args) {
        A131_PalindromePartitioning solution = new A131_PalindromePartitioning();
    }

    /** use dfs with backtracking to find all possible solutions */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void dfs(List<List<String>> result, List<String> tempList, String s, int pos) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                tempList.add(s.substring(pos, i + 1));
                // WARNING: dfs() will pass i + 1 for next recursion, NOT pos + 1
                dfs(result, tempList, s, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
