public class A172_FactorialTrailingZeroes {
    public static void main(String[] args) {
        A172_FactorialTrailingZeroes solution = new A172_FactorialTrailingZeroes();
        int myInput = 200;
        int myResult = solution.trailingZeroes(myInput);
        System.out.println(myResult);
    }

    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        else {
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
