public class A807_MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        A807_MaxIncreaseToKeepCitySkyline solution = new A807_MaxIncreaseToKeepCitySkyline();
        int[][] input = {{3,0,8,4}, {2,4,5,7}, {9,2,6,3}, {0,3,1,0}};
        int output = solution.maxIncreaseKeepingSkyline(input);
        System.out.println(output);
    }

    /** Use two arrays to store max number of each row and max number of each column. For each cell, the updated
     * value should be min value of its corresponding rowMax and columnMax */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[] rowMax = new int[n];
        int[] columnMax = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }

        int increasing = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ceiling = Math.min(rowMax[i], columnMax[j]);
                if (ceiling > grid[i][j]) {
                    increasing += ceiling - grid[i][j];
                }
            }
        }
        return increasing;
    }
}
