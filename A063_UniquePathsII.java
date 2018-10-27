public class A063_UniquePathsII {
    public static void main(String[] args) {
        A063_UniquePathsII solution = new A063_UniquePathsII();
        int[][] inputs = {{1, 0}};
        int output = solution.uniquePathsWithObstacles(inputs);
        System.out.println(output);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 1;
        }

        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        //initialize values of the first line and first column to 1 except obstacle point
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            }
            //once find an obstacle, we cannot access the rest points in the first column
            else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            }
            //once find an obstacle, we cannot access the rest points in the first line
            else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //if there is an obstacle, reset value of current position to 0
                //because we cannot pass from current obstacle point to any other points
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                //general case, fill out dp table
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
