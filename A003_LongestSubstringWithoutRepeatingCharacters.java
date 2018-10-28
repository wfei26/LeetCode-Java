import java.util.HashMap;

public class A003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        A003_LongestSubstringWithoutRepeatingCharacters solution = new A003_LongestSubstringWithoutRepeatingCharacters();
        String myInput = "abba";
        int myResults = solution.lengthOfLongestSubstring(myInput);
        System.out.println(myResults);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        //key: every character; value: least recent index
        HashMap<Character, Integer> map = new HashMap<>();

        //keep a sliding window from i to j, which stores the current max length
        //that contains unique characters
        for (int i = 0, j = 0; j < s.length(); j++) {
            //if we find a duplicate element, do not add it into sliding window
            //but move left pointer forward
            //Also, compare with index of current left pointer, update the left pointer index
            //or if new position is greater than current left pointer index
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);

            //update max window size
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
