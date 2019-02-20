public class A995_MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        A995_MinimumNumberOfKConsecutiveBitFlips solution = new A995_MinimumNumberOfKConsecutiveBitFlips();
        int[] input = {0,0,0,1,0,1,1,0};
        int output = solution.minKBitFlips(input, 3);
        System.out.println(output);
    }

    /** Applying Greedy algorithm, we go through the array, and once we see a "0", will perform a flip.
     * Because no matter what order we flip, we must flip every 0 to 1 finally. Then the best way is that we flip 0
     * immediately once we see 0 in the array. We can also prove this greedy algorithm by contradiction */
    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            // once we found the first '0' in current iteration, flip consecutive K coins start from this '0'
            if (A[i] == 0) {
                // if there still exist 0, but the rest of length is not enough to flip K coins, return -1 directly
                // after all iterations, if we never return at here, we can guarantee that we flipped all 0 to 1
                if (i + K > A.length) {
                    return -1;
                }
                // WARNING: flip K coins start from current '0', j should be scanned in range [i, i + K), NOT [i, K)
                for (int j = i; j < i + K; j++) {
                    if (A[j] == 0) {
                        A[j] = 1;
                    }
                    else {
                        A[j] = 0;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
