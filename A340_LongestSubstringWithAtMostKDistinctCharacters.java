import java.util.HashMap;

public class A340_LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        A340_LongestSubstringWithAtMostKDistinctCharacters solution = new A340_LongestSubstringWithAtMostKDistinctCharacters();
        String myInput = "eceba";
        int k = 2;
        int myResults = solution.lengthOfLongestSubstringKDistinct(myInput, k);
        System.out.println(myResults);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.size() <= k) {
                char c = s.charAt(right);
                map.put(c, right);
            }
            if (map.size() > k) {
                int leftMost = s.length() - 1;
                for (int val : map.values()) {
                    leftMost = Math.min(leftMost, val);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                left = leftMost + 1;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
