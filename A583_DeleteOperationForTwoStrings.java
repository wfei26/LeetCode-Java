public class A583_DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        A583_DeleteOperationForTwoStrings solution = new A583_DeleteOperationForTwoStrings();
        String word1 = "sea";
        String word2 = "eat";
        int output = solution.minDistance(word1, word2);
        System.out.println(output);
    }

    /** find longest common subsequence, and get length of LCS. Then we have difference between w1 and LCS,
     * difference between w2 and LCS, their sum is our result */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // sub-problem: dp[i][j] represents length lf LCS of word1(0, i - 1) and word2(0, j - 1)
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // (n - len of LCS) + (m - len of LCS) will be the total number of edit distance of delete operation
        return n + m - dp[n][m] * 2;
    }
}
