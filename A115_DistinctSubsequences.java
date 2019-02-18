public class A115_DistinctSubsequences {
    public static void main(String[] args) {
        A115_DistinctSubsequences solution = new A115_DistinctSubsequences();
        String s = "babgbag";
        String t = "bag";
        int output = solution.numDistinct(s, t);
        System.out.println(output);
    }

    /**
     * sub-problem: dp[i][j] represents number of subsequence when we match first i characters of T
     * and first j characters of S
     *
     * base case: dp[0][j] = 1 for all j, since when i = 0, we do not need to match any characters,
     * but empty string is a valid subsequence
     *
     * recurrence relation:
     * 1. dp(i, j) = dp(i - 1, j - 1) + dp(i, j - 1) when t[i - 1] == s[j - 1]
     * because when two character are equal in s and t, we can choose either match the current character or
     * skip this character in S. If match, then use i-1, j-1, if skip, then use i, j-1
     * 2. dp(i, j) = dp(i)(j - 1) when t[i - 1] and s[j - 1] does not match, since we should skip matching ith
     * character in T
     * */
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[tlen + 1][slen + 1];

        // base case
        for (int j = 0; j < s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= tlen; i++) {
            for (int j = 1; j <= slen; j++) {
                // when match
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
                // when not match
                else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[tlen][slen];
    }
}
