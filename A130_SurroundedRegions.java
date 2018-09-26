public class A130_SurroundedRegions {
    public static void main(String[] args) {
        A130_SurroundedRegions solution = new A130_SurroundedRegions();
        char[][] inputs = {{'X','O','X','X'},
                           {'X','O','O','X'},
                           {'X','X','O','X'},
                           {'X','O','X','X'}};
    }

    public void solve(char[][] board) {
        int rowNum = board.length, colNum = board[0].length;
        if (board == null || rowNum == 0) {
            return;
        }

        for (int i = 0; i < rowNum; i++) {
            checkO(board, i, 0);
        }
    }

    public void checkO(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] == 'O') {
            board[row][col] = 'T';
            checkO(board, row + 1, col);
            checkO(board, row - 1, col);
            checkO(board, row, col + 1);
            checkO(board, row, col - 1);
        }
    }
}
