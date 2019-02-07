public class A392_IsSubsequence {
    public static void main(String[] args) {
        A392_IsSubsequence solution = new A392_IsSubsequence();
        String S = "agdc";
        String T = "ahbgdc";
        boolean output = solution.isSubsequence(S, T);
        System.out.println(output);
    }

    /** two pointer solution */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
