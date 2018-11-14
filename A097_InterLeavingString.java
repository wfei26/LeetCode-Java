public class A097_InterLeavingString {
    public static void main(String[] args) {
        A097_InterLeavingString solution = new A097_InterLeavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean output = solution.isInterleave(s1, s2, s3);
        System.out.println(output);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), l = s3.length();
        if (n + m != l) {
            return false;
        }

        //Subproblem: dp(i, j) represents if s3 is interleaving at (i+j)th position when s1 is at
        //ith position, and s2 is at jth position. 0th position means empty string.
        /*
        * if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving.
        * If only s1 is empty, then if previous s2 position is interleaving and current s2 position
        * char is equal to s3 current position char, it is considered interleaving. similar idea
        * applies to when s2 is empty. when both s1 and s2 is not empty, then if we arrive i, j
        * from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal,
        * it s interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already interleaving
        * and j and current s3 position equal. it is interleaving.
        * */
        boolean dp[][] = new boolean[n + 1][m + 1];

        //Base case:
        //* dp(0, 0) = true since there are two empty strings
        //* dp(i, 0) = dp(i - 1, j) && s1(i - 1) == s3(i - 1)
        //* dp(0, j) = dp(i, j - 1) && s2(j - 1) == s3(j - 1)
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
                else if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }

                //Recurrence relation:
                //dp(i, j) = dp(i - 1, j) && (s1(i - 1) == s3(i + j - 1))
                // || dp(i, j - 1) && (s2(j - 1) == s3(i + j - 1)
                else if (i != 0 && j != 0){
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))
                            || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        //Return: dp(n, m)
        return dp[n][m];
    }
}
