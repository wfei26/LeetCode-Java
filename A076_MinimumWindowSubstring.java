import java.util.HashMap;
import java.util.Map;

public class A076_MinimumWindowSubstring {
    public static void main(String[] args) {
        A076_MinimumWindowSubstring solution = new A076_MinimumWindowSubstring();
        String strA = "a";
        String strB = "a";
        String myResult = solution.minWindow(strA, strB);
        System.out.println(myResult);
    }

    /**
     * classical sliding window problem
     * Step 1: count frequency of each character in t, also count how many different characters exist in t
     * Step 2: keep a sliding window, move right pointer until the window contains all characters from t
     * Step 3: iteratively move left pointer and update min result until the window does not contain all characters from t
     * */
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                count++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int minLen = s.length() + 1;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            if (map.containsKey(curChar)) {
                map.put(curChar, map.get(curChar) - 1);
                if (map.get(curChar) == 0) {
                    count--;
                }
            }

            // iteratively move left pointer and update min result until the window does not contain all characters from t
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    // WARNING: MUST determine whether frequency of current character is greater than 0 or not
                    // since there may exist some characters with negative frequencies: eg. s = abababc, t = abc
                    if (map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}
