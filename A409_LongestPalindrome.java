import java.util.HashMap;
import java.util.Map;

public class A409_LongestPalindrome {
    public static void main(String[] args) {
        A409_LongestPalindrome solution = new A409_LongestPalindrome();
        String input = "ccc";
        int output = solution.longestPalindrome(input);
        System.out.println(output);
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int result = 0;
        boolean flag = true;
        for (int frequency : map.values()) {
            // if frequency if even, use them all
            if (frequency % 2 == 0) {
                result += frequency;
            }
            // if frequency if odd, we can only use odd number one time
            // and feel free to use the rest of even number
            else {
                if (flag) {
                    result += 1;
                    flag = false;
                }
                if (frequency > 1) {
                    result += frequency - 1;
                }
            }
        }
        return result;
    }
}
