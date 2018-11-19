public class A289_GameOfLife {
    public static void main(String[] args) {
        A289_GameOfLife solution = new A289_GameOfLife();
        int[][] input = {{0,1,0},
                         {0,0,1},
                         {1,1,1},
                         {0,0,0}};
        solution.gameOfLife(input);
        for (int[] line : input) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /*
    * To solve it in place, we use 2 bits to store 2 states:
    *
    * [2nd bit, 1st bit] = [next state, current state]
    * - 00  dead (next) <- dead (current)
    * - 01  dead (next) <- live (current)
    * - 10  live (next) <- dead (current)
    * - 11  live (next) <- live (current)
    *
    * In the beginning, every cell is either 00 or 01.
    * Notice that 1st state is independent of 2nd state.
    * Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
    * Let's count # of neighbors from 1st state and set 2nd state bit.
    * Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
    * In the end, delete every cell's 1st state by doing >> 1.
    * For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.
    *
    * Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
    * Transition 00 -> 10: when board == 0 and lives == 3.
    *
    * To get the current state, simply do
    * board[i][j] & 1
    * To get the next state, simply do
    * board[i][j] >> 1
    * */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int lives = countLives(board, n, m, i, j);

                // At the beginning, every 2nd bit is 0
                // So we only need to care about when will the 2nd bit become 1
                if (board[i][j] == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                else if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        // shift all bit numbers to right by 1, to get the next states
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] /= 2;
            }
        }
    }

    // search all 8 positions (depends on how many do they exist) around the current cell
    // count number of live cells around it except itself
    // eg: *  *  *
    //     *  x  *
    //     *  *  *
    public int countLives(int[][] board, int n, int m, int i, int j) {
        int count = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, n - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, m - 1); y++) {
                // count all live cells except itself
                if (x == i && y == j) {
                    continue;
                }
                count += board[x][y] & 1;
            }
        }
        return count;
    }
}
