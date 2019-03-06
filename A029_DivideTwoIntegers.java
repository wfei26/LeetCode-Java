public class A029_DivideTwoIntegers {
    public static void main(String[] args) {
        A029_DivideTwoIntegers solution = new A029_DivideTwoIntegers();
        int res = solution.divide(100, 4);
        System.out.println(res);
    }

    /** The key idea is to find how many number of divisors we could add together to reach dividend */
    public int divide(int dividend, int divisor) {
        // corner case: absolute value of MIN is 1 greater than MAX value
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // decide the sign of final quotient result
        boolean negativeDividend = (dividend < 0);
        boolean negativeDivisor = (divisor < 0);
        int sign = 1;
        if (negativeDividend != negativeDivisor) {
            sign = -1;
        }

        int quotient = 0;
        // WARNING: to avoid integer overflow, convert numbers to long type
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        while (longDivisor <= longDividend){
            long temp = longDivisor;
            // numOfDivisor represents number of divisor we need to multiply with divisor to get the current temp value
            long numOfDivisor = 1;

            // use idea of binary search to find maximum exponent value of current divisor we could reach, and then
            // subtract the max value, deal with the rest of value in next iterations
            while (longDividend >= (temp << 1)) {
                temp <<= 1;
                numOfDivisor <<= 1;
            }

            longDividend -= temp;
            quotient += numOfDivisor;
        }
        return sign == 1 ? quotient : -quotient;
    }
}
