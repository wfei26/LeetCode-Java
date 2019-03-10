public class A073_SetMatrixZeroes {
    public static void main(String[] args) {
        A073_SetMatrixZeroes solution = new A073_SetMatrixZeroes();
    }

    /** Use first row and first column as zero flag for the entire row and entire column, respectively. Once we find a
     * zero, set first index of current row and current column to zero. After pre-processing, traverse the entire matrix
     * again, if we have first index of row or column equals to zero, set current position to zero. However, we need to
     * deal with first row, first column and other rows, columns separately, because we do not want to mess up flags */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

        // check if first column has 0
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
            }
        }

        // check if first row has 0
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
            }
        }

        // set zero flags for all valid candidate rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // update all valid candidate rows and columns, set all elements to zero
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set first column to zero is first column originally has zero
        if (isFirstColumnZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        // set first row to zero is first row originally has zero
        if (isFirstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
