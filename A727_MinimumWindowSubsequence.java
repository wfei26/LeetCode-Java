public class A727_MinimumWindowSubsequence {
    public static void main(String[] args) {
        A727_MinimumWindowSubsequence solution = new A727_MinimumWindowSubsequence();
        String s = "abcdebdde";
        String t = "bde";
        String output = solution.minWindow(s, t);
        System.out.println(output);
    }

    /**
     * we can traverse from left to right, find a possible candidate until reach the first ending character of T
     * eg: for the string ""
     * */
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }

        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < S.length()) {
            int tIndex = 0;
            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == T.length()) {
                    break;
                }
                right++;
            }

            if (right == S.length()) {
                break;
            }

            int left = right;
            tIndex = T.length() - 1;
            while (left >= 0) {
                if (S.charAt(left) == T.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0) {
                    break;
                }
                left--;
            }
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                result = S.substring(left, right + 1);
            }
            right = left + 1;
        }
        return result;
    }
}
