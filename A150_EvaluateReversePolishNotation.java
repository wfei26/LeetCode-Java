import java.util.Stack;

public class A150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        A150_EvaluateReversePolishNotation myRPN = new A150_EvaluateReversePolishNotation();
        String[] inputs = {"2", "1", "+", "3", "*"};
        int output = myRPN.evalRPN(inputs);
        System.out.println(output);
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        //WARNING: DO NOT define an stack with String type
        //because you need to do the calculation for elements in stack
        Stack<Integer> stack = new Stack<>();
        for (String item : tokens) {
            //CAUTION: DO NOT USE "==" to determine equality of two strings
            if(item.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (item.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                //be careful of the pop order of stack
                stack.push(b - a);
            }
            else if (item.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (item.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else {
                //IMPORTANT: convert String to int: Integer.parseInt(str)
                stack.push(Integer.valueOf(item));
            }
        }
        return stack.pop();
    }
}
