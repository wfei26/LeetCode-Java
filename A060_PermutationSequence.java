import java.util.LinkedList;

public class A060_PermutationSequence {
    public static void main(String[] args) {
        A060_PermutationSequence solution = new A060_PermutationSequence();
    }

    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i; // factorial
        }

        StringBuilder sb = new StringBuilder();
        for (k--; n > 0; n--) {
            factorial /= n; // get fac(n - 1), eg: (1 * 2 * 3) / 3 = 2
            int curNum = nums.remove(k / factorial); // get the index in num list, eg: k = 5, k-- / f = 4 / 2 = 2
            sb.append(curNum);
            k %= factorial; // get sub-position of next number, eg: 4 % 2 = 0
        }

        return sb.toString();
    }
}
