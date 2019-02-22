public class A091_DecodeWays {
    public static void main(String[] args) {
        A091_DecodeWays solution = new A091_DecodeWays();
        String input = "226";
        int output = solution.numDecodings(input);
        System.out.println(output);
    }

    /**
     * sub-problem: dp[i] represents number of decode ways from index 0 to i - 1
     * base case: dp[0] = 1, dp[1] = 1 if s[0] != 0
     * recurrence relation:
     * dp[i] += dp[i - 1] if s[i - 1] != 0
     * dp[i] += dp[i - 2] if substring between i - 2 to i - 1 can form a number between 10 to 26
     * */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        else {
            dp[0] = 0;
        }

        for (int i = 2; i < n + 1; i++) {
            int oneDigitNum = s.charAt(i - 1) - '0';
            int twoDigitNum = (s.charAt(i - 2) - '0') * 10 + oneDigitNum;

            if (oneDigitNum != 0) {
                dp[i] += dp[i - 1];
            }
            if (twoDigitNum >= 10 && twoDigitNum <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
