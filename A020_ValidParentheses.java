import java.util.Stack;

public class A020_ValidParentheses {
    public static void main(String[] args) {
        A020_ValidParentheses solution = new A020_ValidParentheses();
        String input = "(){[]{()}}";
        boolean myResult = solution.isValid(input);
        if (myResult) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                myStack.push(')');
            }
            else if (c == '[') {
                myStack.push(']');
            }
            else if (c == '{') {
                myStack.push('}');
            }
            else if (myStack.isEmpty() || myStack.pop() != c) {
                return false;
            }
        }
        return myStack.isEmpty();
    }
}
