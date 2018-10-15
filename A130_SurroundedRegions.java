public class A130_SurroundedRegions {
    public static void main(String[] args) {
        A130_SurroundedRegions solution = new A130_SurroundedRegions();
        char[][] myBoard = {{'X','X','X','X'},
                            {'X','O','O','X'},
                            {'X','X','O','X'},
                            {'X','O','X','X'}};
        solution.solve(myBoard);
        for (char[] line : myBoard) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rowLen = board.length, colLen = board[0].length;
        //check left border and right border
        for (int i = 0; i < rowLen; i++) {
            checkO(board, i, 0);
            //try to optimize the solution, if border has only one line
            //we do not have to call checkO() again
            if (colLen > 1) {
                checkO(board, i, colLen - 1);
            }
        }

        //check top border and bottom border
        for (int i = 1; i < colLen - 1; i++) {
            checkO(board, 0, i);
            //try to optimize the solution, if border has only one column
            //we do not have to call checkO() again
            if (rowLen > 1) {
                checkO(board, rowLen - 1, i);
            }
        }

        //change the rest of ‘O’ to ‘X’
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        //change ’T’ back to ‘O’ again to keep invalid ‘O’ unchanged for the correct result
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void checkO(char[][] board, int row, int col) {
        if (board[row][col] == 'O') {
            board[row][col] = 'T';
            //DO NOT FORGET to check out of boundary exception when doing recursive call
            if (row > 1) {
                checkO(board, row - 1, col);
            }
            if (col > 1) {
                checkO(board, row, col - 1);
            }
            if (row < board.length - 1) {
                checkO(board, row + 1, col);
            }
            if (col < board[0].length - 1) {
                checkO(board, row, col + 1);
            }
        }
    }
}
