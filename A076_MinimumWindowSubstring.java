import java.util.HashMap;

public class A076_MinimumWindowSubstring {
    public static void main(String[] args) {
        A076_MinimumWindowSubstring solution = new A076_MinimumWindowSubstring();
        String strA = "a";
        String strB = "a";
        String myResult = solution.minWindow(strA, strB);
        System.out.println(myResult);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        String result = "";
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
            else {
                map.put(t.charAt(i), 1);
                count++;
            }
        }

        int minLen = s.length() + 1;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) == 0) {
                    count--;
                }

                while (count == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        result = s.substring(left, left + minLen);
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count++;
                        }
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
