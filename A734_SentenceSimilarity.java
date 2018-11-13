import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class A734_SentenceSimilarity {
    public static void main(String[] args) {
        A734_SentenceSimilarity solution = new A734_SentenceSimilarity();
        String[][] dict = {{"great", "fine"}, {"drama", "acting"}, {"skills", "talent"}};
        String[] input1 = {"great", "acting", "skills"};
        String[] input2 = {"fine", "drama", "talent"};
        boolean output = solution.areSentencesSimilar(input1, input2, dict);
        System.out.println(output);
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        HashMap<String, Set<String>> dict = new HashMap<>();
        for (String[] pair : pairs) {
            dict.putIfAbsent(pair[0], new HashSet<>());
            dict.putIfAbsent(pair[1], new HashSet<>());
            dict.get(pair[0]).add(pair[1]);
            dict.get(pair[1]).add(pair[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            //determine if two words are same
            if (word1.equals(word2)) {
                continue;
            }
            //then determine if two words have relationship
            if (dict.containsKey(word1)) {
                if (!dict.get(word1).contains(word2)) {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
