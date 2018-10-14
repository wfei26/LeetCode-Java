import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A242_ValidAnagram {
    public static void main(String[] args) {
        A242_ValidAnagram solution = new A242_ValidAnagram();
        String a = "anagram";
        String b = "nagaram";
        Boolean myResult = solution.isAnagram(a, b);
        if (myResult) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        for (int frequency : map) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }
}
