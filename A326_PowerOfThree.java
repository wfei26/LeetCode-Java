public class A326_PowerOfThree {
    public static void main(String[] args) {
        A326_PowerOfThree solution = new A326_PowerOfThree();
    }

    /** iteratively divide by 3 until n % 3 != 0, then the final division result should be 1 */
    public boolean isPowerOfThree(int n) {
        if (n > 1) {
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }
}
