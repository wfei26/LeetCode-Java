public class A125_ValidPalindrome {
    public static void main(String[] args) {
        A125_ValidPalindrome solution = new A125_ValidPalindrome();
        String input = "A man, a plan, a canal: Panama";
        boolean output = solution.isPalindrome(input);
        System.out.println(output);
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
