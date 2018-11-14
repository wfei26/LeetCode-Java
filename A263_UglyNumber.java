public class A263_UglyNumber {
    public static void main(String[] args) {
        A263_UglyNumber solution = new A263_UglyNumber();
        int input = 12;
        boolean output = solution.isUgly(input);
        System.out.println(output);
    }

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        //iteratively divide input number to 2, 3 and 5, and then determine
        //whether the remainder equal to 1
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
