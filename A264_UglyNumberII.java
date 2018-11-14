public class A264_UglyNumberII {
    public static void main(String[] args) {
        A264_UglyNumberII solution = new A264_UglyNumberII();
        int input = 10;
        int output = solution.nthUglyNumber(input);
        System.out.println(output);
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        //subproblem: dp(i) represents (i + 1)th ugly number
        int[] dp = new int[n];
        //base case: dp(0) = 1, which is the first ugly number
        dp[0] = 1;
        //use a pointer to keep track of where the 2, 3 and 5 are going to multiply in the next step
        //because any existed number will be multiplied by 2, 3 and 5 once and only once, otherwise duplicate
        int ptrTwo = 0, ptrThree = 0, ptrFive = 0;

        //Essentially, we have to multiply the existed ugly numbers by 2, 3 and 5 to get a bigger ugly number,
        //however, if we blindly multiply all the existed numbers by 2, 3 and 5, then the number could grow
        //much faster than needed. Hence, every time we only try to find the next smallest ugly number.
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[ptrTwo] * 2, dp[ptrThree] * 3), dp[ptrFive] * 5);

            //when we find the next minimum, we can move on the corresponding pointer, otherwise, if it always
            //stays at the already existed ugly number which would makes pointer useless
            if (dp[i] == dp[ptrTwo] * 2) {
                ptrTwo++;
            }
            if (dp[i] == dp[ptrThree] * 3) {
                ptrThree++;
            }
            if (dp[i] == dp[ptrFive] * 5) {
                ptrFive++;
            }
        }
        //return dp[n - 1] means nth ugly number
        return dp[n - 1];
    }
}
