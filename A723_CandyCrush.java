import java.util.HashSet;
import java.util.Set;

public class A723_CandyCrush {
    public static void main(String[] args) {
        A723_CandyCrush solution = new A723_CandyCrush();
        int[][] candies = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},
                {5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        int[][] res = solution.candyCrush(candies);
        for (int[] line : res) {
            for (int num : line) {
                System.out.print(num + "     ");
            }
            System.out.println();
        }
    }

    public int[][] candyCrush(int[][] board) {
        Set<coordinate> set = new HashSet<>();
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curNum = board[i][j];
                if (curNum == 0) {
                    continue;
                }
                // two conditions:
                // 1. three or more same candies in same row
                // 2. three or more same candies in same column
                // then we add every candidate coordinate to the set
                if ((i > 1 && board[i - 2][j] == curNum && board[i - 1][j] == curNum) ||
                        (i > 0 && i < n - 1 && board[i - 1][j] == curNum && board[i + 1][j] == curNum) ||
                        (i < n - 2 && board[i + 1][j] == curNum && board[i + 2][j] == curNum) ||
                        (j > 1 && board[i][j - 2] == curNum && board[i][j - 1] == curNum) ||
                        (j > 0 && j < m - 1 && board[i][j - 1] == curNum && board[i][j + 1] == curNum) ||
                        (j < m - 2 && board[i][j + 1] == curNum && board[i][j + 2] == curNum)) {
                    set.add(new coordinate(i, j));
                }
            }
        }

        // recursion exit: when there is no more candies need to crush
        if (set.isEmpty()) {
            return board;
        }

        // for all points that need to crush, set to 0, and invoke update function
        for (coordinate coordinates : set) {
            board[coordinates.x][coordinates.y] = 0;
        }
        dropBoard(board);
        return candyCrush(board);
    }

    // use two pointers to update board
    public void dropBoard(int[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            // top pointer points the first non-zero point above a set of zeros
            // bottom pointer points first non-assigned point
            int top = board.length - 1, bottom = board.length - 1;
            while (top >= 0) {
                if (board[top][i] == 0) {
                    top--;
                }
                else {
                    board[bottom--][i] = board[top--][i];
                }
            }
            // after crush all zeros and re-assign these values, set the top values to 0
            for (;bottom >= 0; bottom--) {
                board[bottom][i] = 0;
            }
        }
    }

    class coordinate {
        int x, y;
        coordinate(int a, int b) {
            x = a;
            y = b;
        }
    }
}
