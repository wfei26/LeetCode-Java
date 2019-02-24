public class A977_SquaresOfASortedArray {
    public static void main(String[] args) {
        A977_SquaresOfASortedArray solution = new A977_SquaresOfASortedArray();
        int[] input = {-7,-3,2,3,11};
        int[] output = solution.sortedSquares(input);
        for (int num : output) {
            System.out.println(num);
        }
    }

    /** use two pointers to iteratively narrow the range of square values */
    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }

        int[] result = new int[A.length];
        for (int r = A.length - 1, i = 0, j = A.length - 1; i <= j; r--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[r] = A[i] * A[i];
                i++;
            }
            else {
                result[r] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
