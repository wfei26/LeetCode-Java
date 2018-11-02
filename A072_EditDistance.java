public class A072_EditDistance {
    public static void main(String[] args) {
        A072_EditDistance editDistance = new A072_EditDistance();
        String w1 = "";
        String w2 = "a";
        int output = editDistance.minDistance(w1, w2);
        System.out.println(output);
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        //subproblem: dp(i, j) represents minimum number of operations required to convert
        //substring(0, i - 1) of word1 and substring(0, j - 1) of word2
        int[][] dp = new int[n + 1][m + 1];

        //base case: dp(i, 0) = i if j == 0; dp(0, j) = j if i == 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        //since dp(i, j) represents status of prefix substring, i.e. (i - 1, j - 1)
        //so we need to traverse from 1 to n and 1 to m
        //MUST use "<=" at here
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                //if two characters are same, we do not need to care about them, they will be automatically matched
                //so we will have dp[i-1][j-1] + 0 for replacing case
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                }

                /*if two characters are not same, we do not need to deal with conversion by three cases, so we will have
                * dp[i - 1][j - 1] + 1 for replacing;
                * eg: abc, abd => replace c to d will cost 1 step, and we can delete (match) d from both of two strings
                * dp[i][j - 1] + 1 for adding (to tail)
                * eg: ab, abd => add d to ab will cost 1 step, and we can delete (match) d from both of two strings
                * but d is actually a virtual character, so we keep i, but use j - 1
                * dp[i - 1][j] + 1 for deleting (from tail)
                * eg: abd, ab => delete d will cost 1 step, and then we will match the rest of i - 1 with j
                */
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                }
            }
        }
        //since dp(n, m) represents status of i - 1 and j - 1, so we return dp[n][m]
        return dp[n][m];
    }
}
