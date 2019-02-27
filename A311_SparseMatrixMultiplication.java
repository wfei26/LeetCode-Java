import java.util.ArrayList;
import java.util.List;

public class A311_SparseMatrixMultiplication {
    public static void main(String[] args) {
        A311_SparseMatrixMultiplication solution = new A311_SparseMatrixMultiplication();
        int[][] input1 = new int[][]{{1, 0, 0}, {-1, 0, 3}};
        int[][] input2 = new int[][]{{7, 0, 0}, {0, 0, 0 }, {0, 0, 1 }};
        int[][] output = solution.multiply(input1, input2);
        for (int[] line : output) {
            for (int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /** use two list to store coordinates of all non-zero numbers of two matrix, respectively. Then traverse all
     * points in listA and listB to multiply two points if y coordinate of pointA is same as x coordinate of pointB */
    public int[][] multiply(int[][] A, int[][] B) {
        List<int[]> sparseListA = new ArrayList<>();
        List<int[]> sparseListB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    sparseListA.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] != 0) {
                    sparseListB.add(new int[]{i, j});
                }
            }
        }

        int[][] result = new int[A.length][B[0].length];
        for (int[] pointA : sparseListA) {
            for (int[] pointB : sparseListB) {
                int aX = pointA[0];
                int aY = pointA[1];
                int bX = pointB[0];
                int bY = pointB[1];
                // if y coordinate of current point in list A is equal to x coordinate of current point in list B
                if (aY == bX) {
                    // WARNING: MUST USE "+=". DO NOT USE "="
                    result[aX][bY] += A[aX][aY] * B[bX][bY];
                }
            }
        }
        return result;
    }
}
