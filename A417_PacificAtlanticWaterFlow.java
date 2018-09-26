import java.util.ArrayList;
import java.util.List;

public class A417_PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        A417_PacificAtlanticWaterFlow solution = new A417_PacificAtlanticWaterFlow();
        int[][] inputs = {{1,2,2,3,5},
                          {3,2,3,4,4},
                          {2,4,5,3,1},
                          {6,7,1,4,5},
                          {5,1,1,2,4}};
        List<int[]> outputs = solution.pacificAtlantic(inputs);
        for (int[] rows : outputs) {
            for (int col : rows) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return results;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        //initialize two boolean arrays to store all satisfied points
        //that can flow to pacific and atlantic, respectively
        boolean[][] pacific = new boolean[rowNum][colNum];
        boolean[][] atlantic = new boolean[rowNum][colNum];

        //recursively fill arrays start from boundary points of left side and right side
        for (int i = 0; i < rowNum; i++) {
            dfs(matrix, pacific, -1, i, 0);
            dfs(matrix, atlantic, -1, i, colNum - 1);
        }

        //recursively fill arrays start from boundary points of left side and right side
        for (int i = 0; i < colNum; i++) {
            dfs(matrix, pacific, -1, 0, i);
            dfs(matrix, atlantic, -1, rowNum - 1, i);
        }

        //find all points that have true values in both of pacific and atlantic arrays
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    results.add(new int[]{i, j});
                }
            }
        }
        return results;
    }

    public void dfs(int[][] matrix, boolean[][] visited, int height, int row, int col) {
        //recursion exit when:
        //1. point out of bound
        //2. current point is lower than previous point (not satisfy the rule)
        //3. current point was visited before
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
                || matrix[row][col] < height || visited[row][col]) {
            return;
        }

        //set current point to true if satisfy the rule
        visited[row][col] = true;
        dfs(matrix, visited, matrix[row][col], row + 1, col);
        dfs(matrix, visited, matrix[row][col], row - 1, col);
        dfs(matrix, visited, matrix[row][col], row, col + 1);
        dfs(matrix, visited, matrix[row][col], row, col - 1);
    }
}
