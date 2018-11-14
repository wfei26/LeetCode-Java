import java.util.HashSet;

public class A202_HappyNumber {
    public static void main(String[] args) {
        A202_HappyNumber solution = new A202_HappyNumber();
        int input = 2;
        boolean output = solution.isHappy(input);
        System.out.println(output);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int squareSum = 0, remainNum = 0;
        //use a hash set to avoid infinite loop
        while (set.add(n)) {
            squareSum = 0;
            //while n is greater than 0, iteratively calculate values by happy number rules
            while (n != 0) {
                remainNum = n % 10;
                squareSum += remainNum * remainNum;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            }
            //trick: still do not know why we use n = squareSum?
            else {
                n = squareSum;
            }
        }
        return false;
    }
}
