public class A562_LongestLineOfConsecutiveOneInMatrix {
    public static void main(String[] args) {
        A562_LongestLineOfConsecutiveOneInMatrix solution = new A562_LongestLineOfConsecutiveOneInMatrix();
        int[][] input = {{0,1,1,0}, {0,1,1,0}, {0,0,0,1}};
        int output = solution.longestLine(input);
        System.out.println(output);
    }

    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int maxRes = 0;
        int n = M.length, m = M[0].length;
        directions direction = new directions(n, m);

        // calculate maximum path for four directions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    // DO NOT FORGET to initialize current position to 1 as base case for DP
                    direction.vertical[i][j] = 1;
                    direction.horizontal[i][j] = 1;
                    direction.diagonal[i][j] = 1;
                    direction.antiDiagonal[i][j] = 1;

                    // dp recurrence relations
                    if (i > 0) {
                        direction.vertical[i][j] += direction.vertical[i - 1][j];
                    }
                    if (j > 0) {
                        direction.horizontal[i][j] += direction.horizontal[i][j - 1];
                    }
                    if (i > 0 && j > 0) {
                        direction.diagonal[i][j] += direction.diagonal[i - 1][j - 1];
                    }
                    if (i > 0 && j < m - 1) {
                        direction.antiDiagonal[i][j] += direction.antiDiagonal[i - 1][j + 1];
                    }
                    maxRes = Math.max(maxRes, Math.max(direction.vertical[i][j], direction.horizontal[i][j]));
                    maxRes = Math.max(maxRes, Math.max(direction.diagonal[i][j], direction.antiDiagonal[i][j]));
                }
            }
        }
        return maxRes;
    }

    class directions {
        int[][] vertical;
        int[][] horizontal;
        int[][] diagonal;
        int[][] antiDiagonal;

        public directions(int n, int m) {
            vertical = new int[n][m];
            horizontal = new int[n][m];
            diagonal = new int[n][m];
            antiDiagonal = new int[n][m];
        }
    }
}
