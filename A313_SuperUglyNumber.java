public class A313_SuperUglyNumber {
    public static void main(String[] args) {
        A313_SuperUglyNumber solution = new A313_SuperUglyNumber();
        int[] input = {2, 7, 13, 19};
        int output = solution.nthSuperUglyNumber(12, input);
        System.out.println(output);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }
}
