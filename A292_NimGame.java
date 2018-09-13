public class A292_NimGame {
    public static void main(String[] args) {
        A292_NimGame solution = new A292_NimGame();
        int input = 8;
        boolean myResult = solution.canWinNim(input);
        System.out.println(myResult);
    }

    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
