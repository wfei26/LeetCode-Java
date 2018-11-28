public class A009_PalindromeNumber {
    public static void main(String[] args) {
        A009_PalindromeNumber solution = new A009_PalindromeNumber();
        boolean myResult = solution.isPalindrome(12321);
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

        int halfReversedNum = 0;
        //reverse right half of original number, and compare with left half to
        //determine if it is a palindrome number
        for (; x > halfReversedNum; x /= 10) {
            halfReversedNum = halfReversedNum * 10 + x % 10;
        }

        //consider both of odd digits number and even digits number
        //DO NOT FORGET to divide by 10 for the reverseNum
        if (x == halfReversedNum || x == halfReversedNum / 10) {
            return true;
        }
        else {
            return false;
        }
    }
}
