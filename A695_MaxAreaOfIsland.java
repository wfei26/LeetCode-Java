public class A695_MaxAreaOfIsland {
    public static void main(String[] args) {
        A695_MaxAreaOfIsland solution = new A695_MaxAreaOfIsland();
        int[][] inputs = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,1,1,0,1,0,0,0,0,0,0,0,0},
                          {0,1,0,0,1,1,0,0,1,0,1,0,0},
                          {0,1,0,0,1,1,0,0,1,1,1,0,0},
                          {0,0,0,0,0,0,0,0,0,0,1,0,0},
                          {0,0,0,0,0,0,0,1,1,1,0,0,0},
                          {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int output = solution.maxAreaOfIsland(inputs);
        System.out.println(output);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int row, int col, int[][] grid) {
        //when current position is in bound and current element is 1, add area by 1 and continue recursively
        //find other 1's, until all four directions reach 0, finally we get area of current island
        if (col >= 0 && row >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1) {
            grid[row][col] = 0;
            return 1 + dfs(row + 1, col, grid) + dfs(row - 1, col, grid)
                     + dfs(row, col + 1, grid) + dfs(row, col - 1, grid);
        }
        //DO NOT forget return 0 for recursion exit when reach 0
        return 0;
    }
}
