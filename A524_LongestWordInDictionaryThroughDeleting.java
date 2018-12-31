import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        A524_LongestWordInDictionaryThroughDeleting solution = new A524_LongestWordInDictionaryThroughDeleting();
        String input = "abpcplea";
        List<String> dict = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        String output = solution.findLongestWord(input, dict);
        System.out.println(output);
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        int max = 0;

        // sort the array by lexicographical order in order to deal with two words with duplicate length
        Collections.sort(d);

        // check if current dictionary string is subsequence of input string
        // if it is and has greater length, update the result string
        for (String str : d) {
            if (isSubsequence(s, str) && str.length() > max) {
                max = str.length();
                result = str;
            }
        }
        return result;
    }

    public boolean isSubsequence(String a, String b) {
        for (int i = 0, j = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(j)) {
                j++;
            }
            if (j == b.length()) {
                return true;
            }
        }
        return false;
    }
}
