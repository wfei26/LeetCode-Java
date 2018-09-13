import java.util.HashMap;

public class A159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        A159_LongestSubstringWithAtMostTwoDistinctCharacters solution = new A159_LongestSubstringWithAtMostTwoDistinctCharacters();
        String myInput = "eceba";
        int myResults = solution.lengthOfLongestSubstringTwoDistinct(myInput);
        System.out.println(myResults);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < s.length();) {
            if (map.size() <= 2) {
                char c = s.charAt(right);
                map.put(c, right);
                right++;
            }
            if (map.size() > 2) {
                int leftMost = s.length() - 1;
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                left = leftMost + 1;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
