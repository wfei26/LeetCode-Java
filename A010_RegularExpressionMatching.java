public class A010_RegularExpressionMatching {
    public static void main(String[] args) {
        A010_RegularExpressionMatching REMatch = new A010_RegularExpressionMatching();
        String str = "";
        String pattern = ".*";
        boolean output = REMatch.isMatch(str, pattern);
        System.out.println(output);
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        //Subproblem: (boolean) dp(i, j) represents there that matching status of original string from index 0 to i - 1
        //with pattern string from index 0 to j - 1
        //CAUTION: length of dp array should be n + 1 and m + 1
        boolean[][] dp = new boolean[n + 1][m + 1];

        /*
         * Base case:
         * dp(0, 0) = true, means empty string and empty pattern
         * dp(0, j) = false as default array value, means empty original string
         * dp(i, 0) = false as default array value, means empty pattern
        */
        dp[0][0] = true;

        //corner case: there exists leading star combo in the pattern, but different character
        //compare with original string. We should treat them as empty, and equal to previous state of j - 2
        //eg: aab and c*a*b*
        for (int i = 1; i < m; i++){
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                //next state is equal to previous state i - 1 -> i -> i + 1
                //it is actually equivalent to dp(i, j) = dp(i, j - 2)
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        /*
         * Recurrence relation:
         * The idea is that we ONLY need to care about character with *, for regular alphabet and . in the pattern,
         * we can easily match them from the original string
         * if str[i] == pattern[j] or pattern[j] == . : dp(i, j) = dp(i - 1, j - 1)
         * else if pattern[j] == * :
         *      if str[i] == pattern[j - 1] or pattern[j - 1] == . :
         *          dp(i, j) = dp(i - 1, j), which means a* counts as multiple of ‘a’
         *              (eg: abbbbb and ab*, equal to state of abbbb and ab*)
         *          OR dp(i, j) = dp(i, j - 1), which means a* counts as only one ‘a’
         *              (eg: abb and abb*, equal to state of abb and ab*)
         *          OR dp(i, j) = dp(i, j - 2), which means a* counts as empty string
         *              (eg: ab and abb*)
         *      else: dp(i, j) = dp(i, j - 2), which means a* does not match anything,
         *      treated as empty, just depends on the boolean status of previous state of dp(i, j - 2)
         */
        //WARNING: a* should always be counted as a combination, DO NOT COUNT as 'a' only and '*' only,
        //"* ONLY" DOES NOT HAVE ANY MEANING
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //if p[j] == s[i] or p[j] == '.' perfectly match
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //if p[i] == '*', deal with all conditions related with '*'
                else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
