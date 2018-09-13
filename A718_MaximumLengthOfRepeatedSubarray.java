public class A718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        A718_MaximumLengthOfRepeatedSubarray solution = new A718_MaximumLengthOfRepeatedSubarray();
        int[] numsA = {1,2,3,2,1};
        int[] numsB = {3,2,1,4,7};
        int myResult = solution.findLength(numsA, numsB);
        System.out.println(myResult);
    }

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int result = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length + 1; i++) {
            for (int j = 0; j < B.length + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        result = Math.max(result, dp[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
