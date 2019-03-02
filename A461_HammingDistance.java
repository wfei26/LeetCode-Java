public class A461_HammingDistance {
    public static void main(String[] args) {
        A461_HammingDistance solution = new A461_HammingDistance();
        int a = 123;
        int b = 456;
        int myResult = solution.hammingDistance(a, b);
        System.out.println(myResult);
    }

    /** Solution 1 */
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (xor >> i) & 1;
        }
        return result;
    }

    /** Solution 2 */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
