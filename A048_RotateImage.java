public class A048_RotateImage {
    public static void main(String[] args) {
        A048_RotateImage solution = new A048_RotateImage();
        int[][] inputs = {{ 5, 1, 9,11},
                          { 2, 4, 8,10},
                          {13, 3, 6, 7},
                          {15,14,12,16}};
        solution.rotate(inputs);
        for (int[] line : inputs) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /** Solution 1: traverse matrix two times
     * step 1: swap line by line between most top and most bottom until reach the middle line
     * step 2: swap every element on the same diagonal until swap all of possible elements */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        /**
         * clockwise rotate
         * first reverse up to down, then swap the symmetry
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
         */
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            for (int k = 0; k < m; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /** Solution 2: traverse matrix only one time
     * from the most outside circle, swap clockwise one by one until swapping all elements, then go to the second circle
     * inside, until doing same operations for all circles in the matrix */
    public void rotate2(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i]; // assign left bottom to left top
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]; // assign right bottom to left bottom
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]; // assign right top to right bottom
                matrix[j][n - i - 1] = temp; // assign left top to right top
            }
        }
    }
}
