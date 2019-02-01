public class A750_NumberOfCornerRectangles {
    public static void main(String[] args) {
        A750_NumberOfCornerRectangles solution = new A750_NumberOfCornerRectangles();
        int[][] input = {{1, 0, 0, 1, 0},
                         {0, 0, 1, 0, 1},
                         {0, 0, 0, 1, 0},
                         {1, 0, 1, 0, 1}};
        int output = solution.countCornerRectangles(input);
        System.out.println(output);
    }

    /**
     * first step: we can keep two horizontal line x1 and x2 unchanged, and use a moving vertical line to scan from
     * left to right to count number of valid vertical line we can find between x1 and x2 (valid means both of
     * grid[x1][k] and grid[x2][k] is equal to 1). Because any two valid vertical lines between x1 and x2 can form
     * a rectangle with connecting two horizontal lines x1 and x2
     *
     * second step: after counting number of vertical lines between two horizontal lines, we can calculate number of
     * rectangles between x1 and x2. The equation should be equivalent to select 2 from total number of vertical lines
     * i.e.: count * (count - 1) / 2
     * */
    public int countCornerRectangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;

        // traverse all possible combination of two horizontal lines x1 and x2
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 0;
                // scan from left to right, count number of valid vertical lines between two i and j
                for (int k = 0; k < m; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        count++;
                    }
                }

                // calculate number of new corner rectangles
                result += count * (count - 1) / 2;
            }
        }
        return result;
    }
}
