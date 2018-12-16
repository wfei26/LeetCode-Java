public class A313_SuperUglyNumber {
    public static void main(String[] args) {
        A313_SuperUglyNumber solution = new A313_SuperUglyNumber();
        int[] input = {2, 7, 13, 19};
        int output = solution.nthSuperUglyNumber(12, input);
        System.out.println(output);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        // stores all super ugly numbers until nth super ugly number
        int[] uglyNums = new int[n];
        // first ugly number should be 1
        uglyNums[0] = 1;
        // each pointer represents current pointer of every prime numbers in primes array
        int[] pointers = new int[primes.length];

        for (int i = 1; i < n; i++) {
            int curMin = Integer.MAX_VALUE;
            int curMinIndex = 0;
            // traverse all possible multiplication results from prime factor candidates
            // then get the minimum one
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * uglyNums[pointers[j]] < curMin) {
                    curMin = primes[j] * uglyNums[pointers[j]];
                    curMinIndex = j;
                }
                //de-duplicate
                else if (primes[j] * uglyNums[pointers[j]] == curMin) {
                    pointers[j]++;
                }
            }
            // set curMin as new ugly number at current index
            uglyNums[i] = curMin;
            // move pointer of current index by 1
            pointers[curMinIndex]++;
        }
        return uglyNums[n - 1];
    }
}
