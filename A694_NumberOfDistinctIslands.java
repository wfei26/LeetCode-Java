import java.util.HashSet;
import java.util.Set;

public class A694_NumberOfDistinctIslands {
    public static void main(String[] args) {
        A694_NumberOfDistinctIslands solution = new A694_NumberOfDistinctIslands();
    }

    /** mark all moving directions when we do dfs searching, then we will find shapes of all islands */
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, ""); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid, i - 1, j, sb, "u");
        dfs(grid, i + 1, j, sb, "d");
        dfs(grid, i, j - 1, sb, "l");
        dfs(grid, i, j + 1, sb, "r");

        /** WARNING: DO NOT FORGET to add path for backtracking, otherwise, we may have same result when we count two
         * distinct islands in some cases
         *
         * eg:              1 1 1   and    1 1 0
         *                  0 1 0          0 1 1
         * with b:          rdbr           rdr
         * without b:       rdr            rdr
         * */
        sb.append("b"); // back
    }
}
