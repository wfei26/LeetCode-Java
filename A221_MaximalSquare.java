public class A221_MaximalSquare {
    public static void main(String[] args) {
        A221_MaximalSquare solution = new A221_MaximalSquare();
    }

    /** Sub-problem: dp[i][j] represents max length of a square that has bottom right corner in matrix[i][j]
     * Base case: dp[0][0] = 0
     * Recurrence relation: dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]), if matrix[i - 1][j - 1] == 1
     * The resultMax length of final max square = Math.max(resultMax, dp[i][j]), update at the ned of every iteration */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];
        int resLength = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // WARNING: DO NOT FORGET to compare with dp value of left top corner as well
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                resLength = Math.max(resLength, dp[i][j]);
            }
        }
        return resLength * resLength;
    }
}
