public class A342_PowerOfFour {
    public static void main(String[] args) {
        A342_PowerOfFour solution = new A342_PowerOfFour();
        boolean output = solution.isPowerOfFour(16);
        System.out.println(output);
    }

    /**
     * The basic idea is from power of 2, We can use "n&(n-1) == 0" to determine if n is power of 2. For power of 4,
     * the additional restriction is that in binary form, the only "1" should always located at the odd position.
     * For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000. So we can use "num & 0x55555555==num" to check if "1" is located
     * at the odd position.
     *
     *  0x55555555 is a hexametrical number，it is 1010101010101010101010101010101 in binary with a length of 32.
     *  To make sure the 1 locates in the odd location.
     * */
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && ((num & 170) == num);
    }
}
