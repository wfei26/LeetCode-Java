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
        if(s.length() == 0) {
            return new ArrayList<>();
        }

        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        return dfs(s, set, new HashMap<>());
    }

    /** break the sentence into two part, check whether set contains first part. If so, recursively check the second part */
    public List<String> dfs(String s, Set<String> set, Map<String, List<String>> map) {
        // retrieve memo from map cache
        if(map.containsKey(s)) {
            return map.get(s);
        }

        List<String> result = new ArrayList<String>();
        // base case: the leaf level (represents the last word of sentence)
        if(set.contains(s)) {
            result.add(s);
        }

        // try every possible prefix string, and recursively check postfix string
        for(int i = 1 ; i < s.length() ; i++) {
            String prefix = s.substring(0, i);
            if(set.contains(prefix)) {
                List<String> tempList = dfs(s.substring(i), set, map);
                for(int j = 0 ; j < tempList.size() ; j++) {
                    result.add(prefix + " " + tempList.get(j));
                }
            }
        }
        // update memo cache
        map.put(s , result);
        return result;
    }
}
