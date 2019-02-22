public class A960_DeleteColumnsToMakeSortedIII {
    public static void main(String[] args) {
        A960_DeleteColumnsToMakeSortedIII solution = new A960_DeleteColumnsToMakeSortedIII();
        String[] input = {"babca","bbazb"};
        int output = solution.minDeletionSize(input);
        System.out.println(output);
    }

    /** The problem is similar to find longest increasing subsequence. The only difference is that we need to find max
     * increasing subsequence for all strings with capturing same indexes for every LCS among these strings. Finally we
     * can use string length subtract length of max LCS to get number of minimum column we should delete */
    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        int minRes = m - 1;
        int maxIncSS = 0;
        int k;
        // the first loop and second loop is completely same as LCS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                // the third loop is an additional loop to check every string on current index
                for (k = 0; k < n; k++) {
                    if (A[k].charAt(j) > A[k].charAt(i)) {
                        break;
                    }
                }
                // if every string on current index is smaller than right bound, we can update max dp value
                if (k == n) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxIncSS = Math.max(maxIncSS, dp[i]);
            minRes = m - maxIncSS;
        }
        return minRes;
    }
}
