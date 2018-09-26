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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, char[][] grid) {
        //recursion exit: DO NOT FORGET to add condition grid[r][c] == '0'!
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        //mark visited points to 0 to avoid trace back
        grid[row][col] = '0';
        dfs(row + 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row - 1, col, grid);
        dfs(row, col - 1, grid);
    }
}
