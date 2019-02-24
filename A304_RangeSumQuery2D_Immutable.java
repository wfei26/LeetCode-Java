public class A304_RangeSumQuery2D_Immutable {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}};
        A304_RangeSumQuery2D_Immutable solution = new A304_RangeSumQuery2D_Immutable(matrix);
        int output1 = solution.sumRegion(2,1,4,3);
        int output2 = solution.sumRegion(1,1,2,2);
        System.out.println(output1);
        System.out.println(output2);
    }


    /**
     * sub-problem: dp[i][j] represents preSum of all elements in the rectangle area between (0,0) to (i-1, j-1)
     * base case: dp[1][1] = matrix[0][0]
     * recurrence relation: dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
     * explanation: top rectangle sum + left rectangle sum - top left common rectangle + new value at current point
     * */
    int[][] dp;
    public A304_RangeSumQuery2D_Immutable(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
    }
}
