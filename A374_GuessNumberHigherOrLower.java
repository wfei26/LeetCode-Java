public class A374_GuessNumberHigherOrLower {
    public static void main(String[] args) {
        A374_GuessNumberHigherOrLower solution = new A374_GuessNumberHigherOrLower();
        int myInput = 10;
        int myResult = solution.guessNumber(myInput);
        System.out.println(myResult);
    }

    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (guess(mid, n) == 0) {
                return mid;
            }
            else if (guess(mid, n) == 1) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public int guess(int num, int target) {
        if (num == target) {
            return 0;
        }
        else if (num < target) {
            return -1;
        }
        else {
            return 1;
        }
    }
}
