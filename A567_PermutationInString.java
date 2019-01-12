
public class A567_PermutationInString {
    public static void main(String[] args) {
        A567_PermutationInString solution = new A567_PermutationInString();
        String s1 = "adb", s2 = "eidbaooo";
        boolean myResult = solution.checkInclusion(s1, s2);
        System.out.println(myResult);
    }


    // use sliding window with map to solve the problem
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int[] map = new int[26];
        // traverse the entire s1 and s1 length of s2, set map frequency value
        for (int i = 0; i < s1.length(); i++) {
            map[s2.charAt(i) - 'a']++;
            map[s1.charAt(i) - 'a']--;
        }

        // if all elements in s1 are canceled by all elements in first s1 length of s2
        // we found the correct answer
        if (isEmptyMap(map)) {
            return true;
        }

        // start from s1.length, continue to move sliding window, once the map is empty
        // we found the correct answer
        for (int i = s1.length(); i < s2.length(); i++) {
            map[s2.charAt(i - s1.length()) - 'a']--;
            map[s2.charAt(i) - 'a']++;
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
