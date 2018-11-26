import java.util.Stack;

public class A844_BackspaceStringCompare {
    public static void main(String[] args) {
        A844_BackspaceStringCompare solution = new A844_BackspaceStringCompare();
        String a = "ab##", b = "c#d#";
        boolean output = solution.backspaceCompare(a, b);
        System.out.println(output);
    }

    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            }
            else {
                stack1.pop();
            }
        }

        for (char c : T.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            }
            else {
                stack2.pop();
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }

        return sb1.toString().equals(sb2.toString());
    }
}
