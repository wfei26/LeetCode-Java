import java.util.Stack;

public class A402_RemoveKDigits {
    public static void main(String[] args) {
        A402_RemoveKDigits solution = new A402_RemoveKDigits();
        String input = "1234567890";
        String output = solution.removeKdigits(input, 9);
        System.out.println(output);
    }

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return num;
        }

        //corner case: delete all of them
        if (num.length() == k) {
            return "0";
        }

        //use a monotonic stack to store control increasing numbers
        Stack<Character> monoStack = new Stack<>();
        char[] strArr = num.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k != 0 && !monoStack.isEmpty() && strArr[i] < monoStack.peek()) {
                monoStack.pop();
                k--;
            }
            monoStack.push(strArr[i]);
        }

        //if k is still greater than 0, drop the rest of k numbers in the tail (top of stack)
        while (k != 0) {
            monoStack.pop();
            k--;
        }

        StringBuilder newStr = new StringBuilder();
        while (!monoStack.isEmpty()) {
            newStr.append(monoStack.pop());
        }
        //DO NOT FORGET to reverse the string after pop out from stack
        newStr.reverse();

        //corner case: remove all leading 0's if exist
        while (newStr.length() != 1 && newStr.charAt(0) == '0') {
            newStr.deleteCharAt(0);
        }

        return newStr.toString();
    }
}
