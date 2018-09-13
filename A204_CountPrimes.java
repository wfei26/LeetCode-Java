import java.util.Arrays;

public class A204_CountPrimes {
    public static void main(String[] args) {
        A204_CountPrimes solution = new A204_CountPrimes();
        int myInput = 10;
        int myResult = solution.countPrimes(myInput);
        System.out.println(myResult);
    }

    public int countPrimes(int n) {
        int result = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(notPrime[i] == false) {
                result++;
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }
        return result;
    }
}
