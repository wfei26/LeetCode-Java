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
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            //try odd length
            extendPalindrome(s, i, i);
            //try even length
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLength);
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //if we have longer palindrome, update globe results
        int curPalinLen = right - left - 1;
        if (maxLength < curPalinLen) {
            start = left + 1;
            maxLength = curPalinLen;
        }
    }
}
