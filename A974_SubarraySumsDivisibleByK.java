public class A974_SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        A974_SubarraySumsDivisibleByK solution = new A974_SubarraySumsDivisibleByK();
    }

    /** count frequency of every subarray sum that less than K. Then any two subarray with same mod value will
     * generate a valid subarray sum divisible by K */
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }

        int[] mod = new int[K];
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            // mod K twice to avoid negative number
            mod[(curSum % K + K) % K]++;
            curSum += A[i];
        }
        // DO NOT FORGET to operate the last preSum
        mod[(curSum % K + K) % K]++;

        int result = 0;
        for (int i = 0; i < K; i++) {

            // use combination equation to calculate number of possible combinations of any two subarray
            // with same mod value (choose 2 from n)
            if (mod[i] > 1) {
                result += mod[i] * (mod[i] - 1) / 2;
            }
        }
        return result;
    }
}
