import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A890_FindAndReplacePattern {
    public static void main(String[] args) {
        A890_FindAndReplacePattern solution = new A890_FindAndReplacePattern();
        String[] input = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> output = solution.findAndReplacePattern(input, pattern);
        for (String str : output) {
            System.out.println(str);
        }
    }

    /** use two maps to build two way mapping from word to pattern and pattern to word for each character
     * once we find there exists an map value of ith character is not equal to word character at i,
     * that word cannot be matched. Key point: once we match two characters at the same index in word and pattern
     * if this character show up again, the mapping relationship cannot be changed. if we see another character
     * affect this mapping relationship, then this word should be failed on pattern matching */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            // decided if a word can match the pattern
            if (match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    public boolean match(String word1, String word2) {
        // word -> pattern mapping
        Map<Character, Character> map1 = new HashMap<>();
        // pattern -> word mapping
        Map<Character, Character> map2 = new HashMap<>();

        if (word1.length() != word2.length()) {
            return false;
        }

        for (int i = 0; i < word1.length(); i++) {
            // MUST check if map contains current character
            if (!map1.containsKey(word1.charAt(i))) {
                map1.put(word1.charAt(i), word2.charAt(i));
            }
            if (!map2.containsKey(word2.charAt(i))) {
                map2.put(word2.charAt(i), word1.charAt(i));
            }

            // if pattern matching between map1 value and word2 character or map2 value and word1 character is failed,
            // then this word cannot match the pattern
            if (map1.get(word1.charAt(i)) != word2.charAt(i) || map2.get(word2.charAt(i)) != word1.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
