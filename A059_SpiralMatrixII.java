public class A059_SpiralMatrixII {
    public static void main(String[] args) {
        A059_SpiralMatrixII solution = new A059_SpiralMatrixII();
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int count = 1;

        while (left <= right && top <= bottom) {
            // left -> right
            for (int j = left; j <= right; j++) {
                result[top][j] = count;
                count++;
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count;
                count++;
            }
            right--;

            // right -> left
            for (int j = right; j >= left; j--) {
                result[bottom][j] = count;
                count++;
            }
            bottom--;

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count;
                count++;
            }
            left++;
        }
        return result;
    }
}
