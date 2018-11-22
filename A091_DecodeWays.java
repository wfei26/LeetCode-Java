public class A091_DecodeWays {
    public static void main(String[] args) {
        A091_DecodeWays solution = new A091_DecodeWays();
        String input = "226";
        int output = solution.numDecodings(input);
        System.out.println(output);
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = 1; i < n; i++) {
            if ((s.charAt(i - 1) - 'A' + 1) * 10 + (s.charAt(i) - 'A' + 1)  <= 26) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
