import java.util.Stack;

public class A071_SimplifyPath {
    public static void main(String[] args) {
        A071_SimplifyPath simplifier = new A071_SimplifyPath();
        String input = "/..";
        String output = simplifier.simplifyPath(input);
        System.out.println(output);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            //if current dir is "..", return to previous dir, so pop the top item from stack
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
            //otherwise, push dir into stack except three conditions:
            //"." current path, eg: ./
            //".." eg: /.. will skip the first condition since stack is empty
            //"" eg: // means /""/
            else if (!dir.equals(".") && !dir.equals("..") && !dir.equals("")) {
                stack.push(dir);
            }
        }

        //corner case: nothing in the stack, return default path
        if (stack.isEmpty()) {
            return "/";
        }

        String result = "";
        while (!stack.isEmpty()) {
            //WARNING: be careful order of string concatenation
            result = "/" + stack.pop() + result;
        }
        return result;
    }
}
