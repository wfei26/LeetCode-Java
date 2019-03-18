public class A419_BattleshipsInABoard {
    public static void main(String[] args) {
        A419_BattleshipsInABoard solution = new A419_BattleshipsInABoard();
        char[][] board = {{'.', '.', '.', 'X'},
                          {'X', 'X', 'X', 'X'},
                          {'.', '.', '.', 'X'}};
        int res = solution.countBattleships(board);
        System.out.println(res);
    }

    /** only count every 'X' that does not have another 'X' on the top and left, so that we can control duplicate
     * battleships. Also, the problem said it will not have a test case that have two battleships connects together */
    public int countBattleships(char[][] board) {
        if (board.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                else if (i > 0 && board[i-1][j] == 'X') {
                    continue;
                }
                else if (j > 0 && board[i][j-1] == 'X') {
                    continue;
                }
                else {
                    result++;
                }
            }
        }
        return result;
    }
}
