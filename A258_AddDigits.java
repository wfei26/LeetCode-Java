public class A258_AddDigits {
    public static void main(String[] args) {
        A258_AddDigits solution = new A258_AddDigits();
        int myInput = 38;
        int myResult = solution.addDigits(myInput);
        System.out.println(myResult);
    }

    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
