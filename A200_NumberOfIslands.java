public class A200_NumberOfIslands {
    public static void main(String[] args) {
        A200_NumberOfIslands solution = new A200_NumberOfIslands();
        char[][] inputs = {{'1','1','0','0','0'},
                           {'1','1','0','0','0'},
                           {'0','0','1','0','0'},
                           {'0','0','0','1','1'}};
        int output = solution.numIslands(inputs);
        System.out.println(output);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(char[][] board, int rowNum, int colNum) {
        //recursion exit: DO NOT FORGET to add condition grid[r][c] == '0'!
        //and MUST add this condition at the end of if statement because we need to check if array index is still in the boundary
        if (rowNum > board.length - 1|| rowNum < 0 || colNum > board[0].length - 1 || colNum < 0 || board[rowNum][colNum] == '0' ) {
            return;
        }
        //mark visited points to 0 to avoid trace back
        board[rowNum][colNum] = '0';
        dfs(board, rowNum + 1, colNum);
        dfs(board, rowNum - 1, colNum);
        dfs(board, rowNum, colNum + 1);
        dfs(board, rowNum, colNum - 1);
    }
}
