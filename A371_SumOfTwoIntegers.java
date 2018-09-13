public class A371_SumOfTwoIntegers {
    public static void main(String[] args) {
        A371_SumOfTwoIntegers solution = new A371_SumOfTwoIntegers();
        int a = 0, b = 7;
        int myResult = solution.getSum(a, b);
        System.out.println(myResult);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
