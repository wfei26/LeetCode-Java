public class A005_LongestPalindromicSubstring {
    public static void main(String[] args) {
        A005_LongestPalindromicSubstring solution = new A005_LongestPalindromicSubstring();
        String input = "babad";
        String output = solution.longestPalindrome(input);
        System.out.println(output);
    }

    /** start from every possible middle point (could be a single character or a pair of characters), extend all
     * possible palindromes and update max length. */
    int start = 0, maxLength = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLength);
    }

    public void extendPalindrome(String s, int left, int right) {
        // WARNING: must use loop at here, not just if statement
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int curPalindromeLen = right - left - 1;

        // MUST update globe variable "start index" as well
        if (curPalindromeLen > maxLength) {
            start = left + 1;
            maxLength = curPalindromeLen;
        }
    }
}
