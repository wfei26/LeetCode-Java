import java.util.HashMap;
import java.util.Map;

public class A290_WordPattern {
    public static void main(String[] args) {
        A290_WordPattern solution = new A290_WordPattern();
        String input = "dog dog dog dog";
        String pattern = "abba";
        boolean output = solution.wordPattern(pattern, input);
        System.out.println(output);
    }

    /** build two way mapping */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] strArr = str.split(" ");

        if (strArr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            if (map1.containsKey(curChar)) {
                // if map1 contains key, but value is not equal to current string
                if (!map1.get(curChar).equals(strArr[i])) {
                    return false;
                }
            }
            else {
                // if map1 does not contains curChar, but map2 contains current string
                // it fails on one to one mapping rule, return false directly
                if (map2.containsKey(strArr[i])) {
                    return false;
                }
                map1.put(curChar, strArr[i]);
                map2.put(strArr[i], curChar);
            }
        }
        return true;
    }
}
