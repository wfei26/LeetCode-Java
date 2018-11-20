public class A680_ValidPalindromeII {
    public static void main(String[] args) {
        A680_ValidPalindromeII solution = new A680_ValidPalindromeII();
        String input = "ececcec";
        boolean output = solution.validPalindrome(input);
        System.out.println(output);
    }

    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        // traverse all palindrome part until reach the character that needs to be adjusted
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }

        // if left pointer is greater than or equal to right pointer, the entire string is palindrome
        if (i >= j) {
            return true;
        }

        // decide whether i + 1 to j or i to j - 1 is palindrome
        if (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
