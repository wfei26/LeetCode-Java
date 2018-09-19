public class A516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        A516_LongestPalindromicSubsequence solution = new A516_LongestPalindromicSubsequence();
        String input = "bbbab";
        int output = solution.longestPalindromeSubseq(input);
        System.out.println(output);
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        //traverse from end to start
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            //move right pointer from i+1 to end
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
