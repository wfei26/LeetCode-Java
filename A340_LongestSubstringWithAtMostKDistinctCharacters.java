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
        for (int left = 0, right = 0; right < s.length(); ) {
            // if map size is less than or equal to limit, we can keep adding new element into window
            if (map.size() <= k) {
                char c = s.charAt(right);
                map.put(c, right);
                right++;
            }

            // Whenever the size of hash map is greater than 2, we should find the character with
            // least (left most) index and then remove it to rebuild the window
            if (map.size() > k) {
                int leftMost = s.length() - 1;
                for (int i : map.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                // new starting point of window
                left = leftMost + 1;
            }
            // calculate window length
            result = Math.max(result, right - left);
        }
        return result;
    }
}
