import java.util.ArrayList;
import java.util.List;

public class A022_GenerateParentheses {
    public static void main(String[] args) {
        A022_GenerateParentheses solution = new A022_GenerateParentheses();
        int input = 3;
        List<String> myResult = solution.generateParenthesis(input);
        for (int i = 0; i < myResult.size(); i++) {
            System.out.println(myResult.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtracking(results, "", 0, 0, n);
        return results;
    }

    public void backtracking(List<String> myList, String curStr, int open, int close, int size) {
        if (curStr.length() == size * 2) {
            myList.add(curStr);
            return;
        }

        if (open < size) {
            backtracking(myList, curStr + "(", open + 1, close, size);
        }
        if (close < open) {
            backtracking(myList, curStr + ")", open, close + 1, size);
        }
    }
}
