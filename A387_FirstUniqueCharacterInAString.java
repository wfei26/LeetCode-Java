import java.util.HashMap;
import java.util.Map;

public class A387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        A387_FirstUniqueCharacterInAString solution = new A387_FirstUniqueCharacterInAString();
        String input = "loveleetcode";
        int output = solution.firstUniqChar(input);
        System.out.println(output);
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        // use hash map, two pass
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
