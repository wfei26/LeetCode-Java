public class A647_PalindromicSubstrings {
    public static void main(String[] args) {
        A647_PalindromicSubstrings solution = new A647_PalindromicSubstrings();
        String input = "abccba";
        int output = solution.countSubstrings(input);
        System.out.println(output);
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = extendPalindrome(s, i, i, result);
            result = extendPalindrome(s, i, i + 1, result);
        }

        return result;
    }

    public int extendPalindrome(String s, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
