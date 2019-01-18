public class A463_IslandPerimeter {
    public static void main(String[] args) {
        A463_IslandPerimeter solution = new A463_IslandPerimeter();
        int[][] input = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int output = solution.islandPerimeter(input);
        System.out.println(output);
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // for every new island found, we add perimeter by 4
                    perimeter += 4;

                    // for any neighbor island on the right or bottom, we subtract perimeter by 2
                    // since we will count again when we traverse the island on the right and bottom of current island
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }
}
