public class A766_ToeplitzMatrix {
    public static void main(String[] args) {
        A766_ToeplitzMatrix solution = new A766_ToeplitzMatrix();
        int[][] myInputs = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        boolean myResult = solution.isToeplitzMatrix(myInputs);
        System.out.println(myResult);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
