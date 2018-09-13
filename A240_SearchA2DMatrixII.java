public class A240_SearchA2DMatrixII {
    public static void main(String[] args) {
        A240_SearchA2DMatrixII solution = new A240_SearchA2DMatrixII();
        int[][] myInputs = {{1,   4,  7, 11, 15},
                            {2,   5,  8, 12, 19},
                            {3,   6,  9, 16, 22},
                            {10, 13, 14, 17, 24},
                            {18, 21, 23, 26, 30}};
        int target = 5;
        boolean myResult = solution.searchMatrix(myInputs, target);
        System.out.println(myResult);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0;) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if (matrix[i][j] > target) {
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
