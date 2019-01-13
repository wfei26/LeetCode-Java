public class A498_DiagonalTraverse {
    public static void main(String[] args) {
        A498_DiagonalTraverse solution = new A498_DiagonalTraverse();
        int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] output = solution.findDiagonalOrder(input);
        for (int num : output) {
            System.out.print(num + " ");
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int n = matrix.length, m = matrix[0].length;
        int[] result = new int[n * m];

        // WARNING: for both inner if-else, the ORDER of checking condition is crucial,
        // if pointer is at top right corner when moving up, we always first check column then row
        // if pointer is at bottom left corner when moving down, we always first check row then column
        int row = 0, col = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];
            // going up and right direction
            if ((row + col) % 2 == 0) {
                // out of right boundary
                if (col == m - 1) {
                    row++;
                }
                // out of top boundary
                else if (row == 0) {
                    col++;
                }
                // general case that still in the boundary
                else {
                    row--;
                    col++;
                }
            }
            // going down and left direction
            else {
                // out of bottom boundary
                if (row == n - 1) {
                    col++;
                }
                // out of left boundary
                else if (col == 0) {
                    row++;
                }
                // general case that still in the boundary
                else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
