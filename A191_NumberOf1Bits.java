public class A191_NumberOf1Bits {
    public static void main(String[] args) {
        A191_NumberOf1Bits solution = new A191_NumberOf1Bits();
        int myInput = 17;
        int myResult = solution.hammingWeight(myInput);
        System.out.println(myResult);
    }

    public int hammingWeight(int n) {
        int count = 0;
        // integer in Java only has 32 bits
        for (int i = 0; i < 32; i++) {
            System.out.println(i);
            System.out.println(n >> i);
            System.out.println();
            if ((n >> i & 1) == 1) {
                System.out.println("------");
                count++;
            }
        }
        return count;
    }
}
