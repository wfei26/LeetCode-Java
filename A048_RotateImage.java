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

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        /*
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
}
