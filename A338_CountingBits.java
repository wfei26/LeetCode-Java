public class A338_CountingBits {
    public static void main(String[] args) {
        A338_CountingBits counter = new A338_CountingBits();
        int input = 5;
        int[] outputs = counter.countBits(input);
        for (int num : outputs) {
            System.out.println(num);
        }
    }

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int curPower = 1;
        for (int i = 1; i <= num; i++) {
            //if value of power of 2 reach to next level, we update the value
            if (curPower * 2 == i) {
                curPower *= 2;
            }
            //dp[i] = dp(current number - current value of power of 2) + 1
            //1 means one digit of current power of 2
            dp[i] = dp[i - curPower] + 1;
        }
        return dp;
    }
}
