public class A338_CountingBits {
    public static void main(String[] args) {
        A338_CountingBits counter = new A338_CountingBits();
        int input = 12;
        int[] outputs = counter.countBits(input);
        for (int num : outputs) {
            System.out.println(num);
        }
    }

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        //this variable means current value of power of 2
        //eg: 2^0 = 1, 2^1 = 2, 2^2 = 4, 2^3 = 8, 2^4 = 16...
        int curPowerOfTwo = 1;

        /*
         * Index : 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
         * num : 0 1 1 2 1 2 2 3 1 2 2 3 2 3 3 4
         * Obviously, this is overlap sub problem, and we can come up the DP solution.
         * For now, we need find the function to implement DP.
         * dp[0] = 0;
         * dp[1] = dp[0] + 1;
         * dp[2] = dp[0] + 1;
         * dp[3] = dp[1] + 1;
         * dp[4] = dp[0] + 1;
         * dp[5] = dp[1] + 1;
         * dp[6] = dp[2] + 1;
         * dp[7] = dp[3] + 1;
         * dp[8] = dp[0] + 1
         * ...
         * This is the function we get, now we need find the other pattern for the function to
         * get the general function. After we analyze the above function, we can get
         * dp[0] = 0;
         * dp[1] = dp[1-1] + 1;
         * dp[2] = dp[2-2] + 1;
         * dp[3] = dp[3-2] + 1;
         * dp[4] = dp[4-4] + 1;
         * dp[5] = dp[5-4] + 1;
         * dp[6] = dp[6-4] + 1;
         * dp[7] = dp[7-4] + 1;
         * dp[8] = dp[8-8] + 1
         * ...
         * Obviously, we can find the pattern for above example, so now we get the general function
         * */
        for (int i = 1; i <= num; i++) {
            //if value of power of 2 reach to next level, we update the value
            if (curPowerOfTwo * 2 == i) {
                curPowerOfTwo *= 2;
            }
            //dp[i] = dp(current number - current value of power of 2) + 1
            //1 means one digit of current power of 2
            dp[i] = dp[i - curPowerOfTwo] + 1;
        }
        return dp;
    }
}
