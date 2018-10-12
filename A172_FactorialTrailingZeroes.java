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
            //n/5 means find all numbers that at least contain one 5
            //recursive call (n/5) means there exists some numbers contain
            //more than one 5
            //eg: 100! : 25, 50, 75, 100 contains two 5's as divisor
            return n / 5 + trailingZeroes(n / 5);
        }
    }
}
