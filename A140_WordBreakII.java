import java.util.*;

public class A140_WordBreakII {
    public static void main(String[] args) {
        A140_WordBreakII solution = new A140_WordBreakII();
        String input = "pineapplepenapple";
        List<String> candidates = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> output = solution.wordBreak(input, candidates);
        for (String str : output) {
            System.out.println(str);
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        return dfs(s, wordDict, new HashMap<>());
    }

    public List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> memo) {
        // prune: retrieve saved results from memo if s occurred before
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        // base case
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        // traverse dictionary, try all prefix possibilities
        for (String word : wordDict) {
            // IMPORTANT: s.startWith(String preStr) will return true if preStr can be a prefix of string s
            if (s.startsWith(word)) {
                // dfs recursion will return all possible combinations of suffix of string s (substring except word)
                // eg: for substring "applepenapple", it will return {"apple pen apple", "applepen apple"}
                List<String> suffixCombinations = dfs(s.substring(word.length()), wordDict, memo);
                // combine all suffix with prefix to form the final string
                for (String suffix : suffixCombinations) {
                    if (suffix != "") {
                        result.add(word + " " + suffix);
                    }
                    else {
                        result.add(word);
                    }
                }
            }
        }
        // store results in memo
        memo.put(s, result);
        return result;
    }
}
