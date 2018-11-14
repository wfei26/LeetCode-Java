public class A413_ArithmeticSlices {
    public static void main(String[] args) {
        A413_ArithmeticSlices solution = new A413_ArithmeticSlices();
        int[] input = {1, 2, 3, 4, 5};
        int output = solution.numberOfArithmeticSlices(input);
        System.out.println(output);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        //use dp thought: result represents total number of arithmetic slices (AS) from 0 to i
        //curSum means current continuous number of AS
        //eg: 1,2,3,4,6,7,8 -> AS stops at 4, and restart to count again from 6, then we need to reset
        //curSum to 0 when 6 - 4 != 4 - 3
        int result = 0, curSum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curSum += 1;
                result += curSum;
            }
            //reset curSum when AS discontinuous
            else {
                curSum = 0;
            }
        }
        return result;
    }
}
