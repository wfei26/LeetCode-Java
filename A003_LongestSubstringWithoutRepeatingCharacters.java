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
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
