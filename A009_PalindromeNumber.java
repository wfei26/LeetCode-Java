public class A009_PalindromeNumber {
    public static void main(String[] args) {
        A009_PalindromeNumber solution = new A009_PalindromeNumber();
        boolean myResult = solution.isPalindrome(121);
        if (myResult) {
            System.out.println("The number is palindrome");
        }
        else {
            System.out.println("The number is not palindrome");
        }

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverseNum = 0;
        for (; x > reverseNum; x /= 10) {
            reverseNum = reverseNum * 10 + x % 10;
        }
        if (x == reverseNum || x == reverseNum / 10) {
            return true;
        }
        else {
            return false;
        }
    }
}
