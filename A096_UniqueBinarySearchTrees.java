public class A096_UniqueBinarySearchTrees {
    public static void main (String[] args) {
        A096_UniqueBinarySearchTrees solution = new A096_UniqueBinarySearchTrees();
        int output = solution.numTrees(3);
        System.out.println(output);
    }

    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        //do not forget to allocate size of n+1 to dp array
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            //dp[i] means there are number of i elements
            //then use j as root, j is between 1 to i
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
