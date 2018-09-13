import java.lang.reflect.Array;
import java.util.Arrays;

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
        char[] strArr1 = s.toCharArray();
        char[] strArr2 = t.toCharArray();
        Arrays.sort(strArr1);
        Arrays.sort(strArr2);
        for (int i = 0; i < strArr1.length && i < strArr2.length; i++) {
            if (strArr1[i] != strArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
