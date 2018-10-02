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

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Set<String> dictionary = new HashSet<>();
        for (String item : wordDict) {
            dictionary.add(item);
        }

        int n = s.length();
        //dp[i] represents if s.substring(0, i-1) can be segmented into a space-separated
        //sequence of one or more dictionary words
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        //loop right pointer from 1 to n
        for (int i = 1; i <= n; i++) {
            //loop left pointer from 0 to i
            for (int k = 0; k < i; k++) {
                //if previous substring from 0 to k - 1 is true
                //and current substring from k to i - 1 is also true
                //we set dp[i] to true, and jump to next iteration
                if (dp[k] && dictionary.contains(s.substring(k, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
