public class A191_NumberOf1Bits {
    public static void main(String[] args) {
        A191_NumberOf1Bits solution = new A191_NumberOf1Bits();
        int myInput = 188;
        int myResult = solution.hammingWeight(myInput);
        System.out.println(myResult);
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
