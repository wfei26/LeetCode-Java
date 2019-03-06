import java.util.ArrayList;
import java.util.List;

public class A054_SpiralMatrix {
    public static void main(String[] args) {
        A054_SpiralMatrix solution = new A054_SpiralMatrix();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix.length - 1;
        int top = 0;
        int bottom = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            // left -> right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right -> left
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;

            // bottom -> top
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
