import java.util.ArrayList;
import java.util.List;

public class A052_NQueensII {
    public static void main(String[] args) {
        A052_NQueensII solution = new A052_NQueensII();
        int input = 4;
        int output = solution.totalNQueens(input);
        System.out.println(output);
    }

    public int totalNQueens(int n) {
        int result = solveNQueens(n).size();
        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }

        char[][] board = new char[n][n];
        //DO NOT FORGET to initialize the entire board to '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, results);
        return results;
    }

    public void dfs(char[][] board, int colNum, List<List<String>> results) {
        if (colNum == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] line : board) {
                //IMPORTANT: we can directly convert a char[] array to a String by using
                //new String(charArr)
                solution.add(new String(line));
            }
            results.add(solution);
        }
        for (int i = 0; i < board.length; i++) {
            if (validPosition(board, i, colNum)) {
                //classical backtracking three steps: add, recursion, remove
                board[i][colNum] = 'Q';
                //WARNING: DO NOT FORGET to add colNum by 1 for next recursive call
                dfs(board, colNum + 1, results);
                board[i][colNum] = '.';
            }
        }
    }

    public boolean validPosition(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                //check three lines same as input position that stores 'Q'
                //two diagonals and one horizontal line
                //No need to check vertical line, because we have the condition j < y
                //CAUTION: DO NOT USE x + i == y + j, must use x + j == y + i for one diagonal condition check
                //because x + i == y + j only considered the diagonal pass to origin, but miss the other cases
                if (board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

