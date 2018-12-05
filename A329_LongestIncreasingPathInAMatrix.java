public class A329_LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        A329_LongestIncreasingPathInAMatrix solution = new A329_LongestIncreasingPathInAMatrix();
        int[][] input = {{9,9,4},
                         {6,6,8},
                         {2,1,1}};
        int output = solution.longestIncreasingPath(input);
        System.out.println(output);
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length, m = matrix[0].length;

        // memoization: store cache value (max distance to cache[i][j]) for each index
        int[][] cache = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int curLen = dfs(matrix, i, j, n, m, cache, Integer.MIN_VALUE);
                result = Math.max(result, curLen);
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int i, int j, int n, int m, int[][] cache, int preVal) {
        // recursion exit 1: if out of bound or current value is less than or equal to previous value
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] <= preVal) {
            return 0;
        }

        // recursion exit 2: if cache value was updated before, return current cache value
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        // recursive step: search for four directions, add 1 for each recursive call
        int max1 = 1 + dfs(matrix, i + 1, j, n, m, cache, matrix[i][j]);
        int max2 = 1 + dfs(matrix, i - 1, j, n, m, cache, matrix[i][j]);
        int max3 = 1 + dfs(matrix, i, j + 1, n, m, cache, matrix[i][j]);
        int max4 = 1 + dfs(matrix, i, j - 1, n, m, cache, matrix[i][j]);

        // update current cache value to max results of dfs searching values
        cache[i][j] = Math.max(max1, Math.max(max2, Math.max(max3, max4)));

        // return max distance
        return cache[i][j];
    }
}
