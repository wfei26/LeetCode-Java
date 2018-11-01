public class A070_ClimbingStairs {
    public static void main(String[] args) {
        A070_ClimbingStairs solution = new A070_ClimbingStairs();
        int myInput = 5;
        int myResult = solution.climbStairs(myInput);
        System.out.println(myResult);
    }

    public int climbStairs(int n) {
        //Be care for the corner(base) cases
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        //dp[i] represents number of ways to climb to stair level of i + 1
        int[] dp = new int[n];

        //base case: climb 1 or 2 steps
        dp[0] = 1;
        dp[1] = 2;

        //start from 2 (level 3), and iteratively fill out dp table
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //return dp[n - 1] for total number of ways to level n
        return dp[n - 1];
    }
}
