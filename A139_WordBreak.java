import java.util.*;

public class A139_WordBreak {
    public static void main(String[] args) {
        A139_WordBreak solution = new A139_WordBreak();
        String input = "applepenapple";
        //REMEMBER how to initialize a list with values!!!
        List<String> dictionary = new ArrayList<>(Arrays.asList("apple", "pen"));
        boolean output = solution.wordBreak(input, dictionary);
        System.out.println(output);
    }

    /**
     * Sub-problem: dp[i] represents whether s.substring(0, i-1) can be segmented into a space-separated
     * sequence of one or more dictionary words
     * Base case: dp[0] = true;
     * Recurrence relation: dp[i] = true if dp[k] && set.contains(s.substring(k, i)), 0 < k < i
     * Return: dp[n]
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for (String word : wordDict) {
            set.add(word);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                // if previous substring from 0 to k - 1 is true and current substring from k to i - 1 is also true
                // we set dp[i] to true, and jump to next iteration
                if (dp[k] && set.contains(s.substring(k, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
