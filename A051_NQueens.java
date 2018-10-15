import java.util.ArrayList;
import java.util.List;

public class A051_NQueens {
    public static void main(String[] args) {
        A051_NQueens solution = new A051_NQueens();
        int input = 4;
        List<List<String>> outputs = solution.solveNQueens(input);
        for (List<String> list : outputs) {
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }

        return results;
    }
}

