import java.util.HashMap;

public class A567_PermutationInString {
    public static void main(String[] args) {
        A567_PermutationInString solution = new A567_PermutationInString();
        String s1 = "adb", s2 = "eidbaooo";
        boolean myResult = solution.checkInclusion(s1, s2);
        System.out.println(myResult);
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] map = new int[26];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            map[s1Arr[i] - 'a']++;
            map[s2Arr[i] - 'a']--;
        }
        if (isEmptyMap(map)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            map[s2Arr[i] - 'a']--;
            map[s2Arr[i - s1.length()] - 'a']++;
            if (isEmptyMap(map)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmptyMap(int[] map) {
        for (int value : map) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
