public class A190_ReverseBits {
    public static void main(String[] args) {
        A190_ReverseBits solution = new A190_ReverseBits();
        int output = solution.reverseBits(1);
        System.out.println(output);
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // if current digit is 1
            // eg: if i = 1, 111010 & 000010 = 000010 != 0
            if ((n & (1 << i)) != 0) {
                // then change the digit on index 31 - i to 1
                // eg: res = 000000 | 010000 = 010000
                result = result | (1 << (31 - i));
            }
        }
        return result;
    }
}
