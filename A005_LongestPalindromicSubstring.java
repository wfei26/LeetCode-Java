public class A005_LongestPalindromicSubstring {
    public static void main(String[] args) {
        A005_LongestPalindromicSubstring solution = new A005_LongestPalindromicSubstring();
        String input = "babad";
        String output = solution.longestPalindrome(input);
        System.out.println(output);
    }

    int start = 0, maxLength = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        //start from middle point, extend all possible palindromes and update max length
        //we need to try every possible start point (or middle starting point) with
        //both of odd length and even length palindrome strings
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLength);
    }

    public void extendPalindrome(String s, int left, int right) {
        //WARNING: must use loop at here, not just if statement
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        //when we exit loop, the current character on left index and right index should not be included
        //in current palindrome string, we we should subtract them
        //i.e. start = left + 1, and curLen = r - l - 1
        int curPalindromeLen = right - left - 1;

        //if we have longer palindrome, update globe results
        if (curPalindromeLen > maxLength) {
            start = left + 1;
            maxLength = curPalindromeLen;
        }
    }
}
