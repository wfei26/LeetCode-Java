import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A884_UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        A884_UncommonWordsFromTwoSentences solution = new A884_UncommonWordsFromTwoSentences();
        String a = "this apple is sweet";
        String b = "this apple is sour";
        String[] output = solution.uncommonFromSentences(a, b);
        for (String str : output) {
            System.out.println(str);
        }
    }

    /** Since the definition of uncommon words has prerequisite that appear exactly once in one of the sentence,
     * we can just use one hash map to count frequency of all words in both of two sentences, and then find all
     * words which only appear once */
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");
        for (String str : arrA) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : arrB) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        // API: convert arraylist to array
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
}
