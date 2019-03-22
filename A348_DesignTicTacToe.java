public class A348_DesignTicTacToe {
    public static void main(String[] args) {
        A348_DesignTicTacToe solution = new A348_DesignTicTacToe(3);
    }

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public A348_DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // use 1 represents player 1 to fill the current position, use -1 to represent player 2
        int curMove = 1;
        if (player != 1) {
            curMove = -1;
        }

        rows[row] += curMove;
        cols[col] += curMove;

        if (row == col) {
            diagonal += curMove;
        }

        if (col == (rows.length - row - 1)) {
            antiDiagonal += curMove;
        }

        int size = rows.length;
        // once we find a line have absolute value 3, it means all three positions on this line have same players
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size  || Math.abs(antiDiagonal) == size) {
            return player;
        }
        return 0;
    }
}
