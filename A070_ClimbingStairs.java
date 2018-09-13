public class A070_ClimbingStairs {
    public static void main(String[] args) {
        A070_ClimbingStairs solution = new A070_ClimbingStairs();
        int myInput = 5;
        int myResult = solution.climbStairs(myInput);
        System.out.println(myResult);
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
