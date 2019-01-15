public class A191_NumberOf1Bits {
    public static void main(String[] args) {
        A191_NumberOf1Bits solution = new A191_NumberOf1Bits();
        int myInput = 6;
        int myResult = solution.hammingWeight(myInput);
        System.out.println(myResult);
    }

    public int hammingWeight(int n) {
        int count = 0;
        /* integer in Java only has 32 bits, so the shifting upper bound will not greater than 32
         * eg: for num 6: 0x0110
         * (0110 >> 0 = 0110) & 0001 = 0
         * (0110 >> 1 = 0011) & 0001 = 1
         * (0110 >> 2 = 0001) & 0001 = 1
         * (0110 >> 3...) the rest of loop will be useless
         * the logic is like shifting every 1 to the right most position, and then use & operand to
         * compare with 0x0001 to see if current right most position is 1 or 0
        **/
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
