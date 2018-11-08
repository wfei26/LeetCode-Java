import java.util.Arrays;

public class A279_PerfectSquares {
    public static void main(String[] args) {
        A279_PerfectSquares solution = new A279_PerfectSquares();
        int input = 21; //16 + 4 + 1
        int output = solution.numSquares(input);
        System.out.println(output);
    }

    public int numSquares(int n) {
        //Subproblem: dp(i) = the least number of perfect square numbers which sum to i.
        int[] dp = new int[n + 1];

        //CAUTION: DO NOT FORGET to initialize every element in dp array to MAX value,
        //since we need to do the min value comparison later
        Arrays.fill(dp, Integer.MAX_VALUE);

        //base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int curMin = Integer.MAX_VALUE;
            //recurrence relation: update curMin by iteratively accessing previous PS from DP table
            for (int j = 1; i - j*j >= 0; j++) {
                curMin = Math.min(curMin, dp[i - j * j] + 1);
            }
            dp[i] = curMin;
        }
        return dp[n];
    }
}
