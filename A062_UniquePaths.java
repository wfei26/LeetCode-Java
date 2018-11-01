public class A062_UniquePaths {
    public static void main(String[] args) {
        A062_UniquePaths solution = new A062_UniquePaths();
        int m = 7, n = 3;
        int output = solution.uniquePaths(m, n);
        System.out.println(output);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //DO NOT FORGET to initialize values of the first line and first column to 1
        //Because we only have one way to reach these points, then we consider them as base cases
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //iteratively fill out dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        //return the dp table value of last position
        return dp[m - 1][n - 1];
    }
}
