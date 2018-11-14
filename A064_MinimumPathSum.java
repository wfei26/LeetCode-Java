public class A064_MinimumPathSum {
    public static void main(String[] args) {
        A064_MinimumPathSum solution = new A064_MinimumPathSum();
        int[][] inputs = {{1, 3, 1},
                          {1, 5, 1},
                          {4, 2, 1}};
        int output = solution.minPathSum(inputs);
        System.out.println(output);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length, m = grid[0].length;

        //subproblem: dp(i, j) represents min path from (0, 0) to (i, j) include point (i, j) itself
        int[][] dp = new int[n][m];

        //base case: dp(0, 0) is equal to value of origin
        dp[0][0] = grid[0][0];

        //other base cases: horizontal wall and vertical wall
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //fill dp table, similar to robot robot problem
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        //return: dp(n - 1, m - 1)
        return dp[n - 1][m - 1];
    }
}
