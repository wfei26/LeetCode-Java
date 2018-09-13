public class A461_HammingDistance {
    public static void main(String[] args) {
        A461_HammingDistance solution = new A461_HammingDistance();
        int a = 123;
        int b = 456;
        int myResult = solution.hammingDistance(a, b);
        System.out.println(myResult);
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
