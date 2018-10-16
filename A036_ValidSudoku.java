import java.util.HashSet;

public class A036_ValidSudoku {
    public static void main(String[] args) {
        A036_ValidSudoku sudokuValidation = new A036_ValidSudoku();
        char[][] inputs = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                           {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                           {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                           {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                           {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                           {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                           {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                           {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                           {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean output = sudokuValidation.isValidSudoku(inputs);
        System.out.println(output);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curVal = board[i][j];
                //DO NOT FORGET to check whether current item is '.' or number
                if (board[i][j] != '.') {
                    //there are 9 cubes in the sudoku board, then we can derive their relative coordinator,
                    //and then get the correct law of them
                    //ie: (0, 0) (0, 1) (0, 2)
                    //    (1, 0) (1, 1) (1, 2)
                    //    (2, 0) (2, 1) (2, 2)
                    //position 0 corresponds index 0, 1, 2
                    //position 1 corresponds index 3, 4, 5
                    //position 2 corresponds index 6, 7, 8
                    int cubeNum = (i / 3 * 3) + (j / 3);
                    if (set.contains("row" + i + curVal) || set.contains("col" + j + curVal) || set.contains("cube" + cubeNum + curVal)) {
                        return false;
                    }
                    set.add("row" + i + curVal);
                    set.add("col" + j + curVal);
                    set.add("cube" + cubeNum + curVal);
                }
            }
        }
        return true;
    }
}
