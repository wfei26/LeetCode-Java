import java.util.HashMap;
import java.util.Stack;

public class A020_ValidParentheses {
    public static void main(String[] args) {
        A020_ValidParentheses solution = new A020_ValidParentheses();
        String input = "(){[]{()}}";
        boolean myResult = solution.isValid(input);
        //boolean myResult = solution.isValidSimplify(input);
        if (myResult) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidSimplify(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            }
            else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
