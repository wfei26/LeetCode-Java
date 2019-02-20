import java.util.LinkedList;
import java.util.Queue;

public class A994_RottingOranges {
    public static void main(String[] args) {
        A994_RottingOranges solution = new A994_RottingOranges();
        int[][] input = {{2,1,1}, {1,1,0}, {0,1,1}};
        int output = solution.orangesRotting(input);
        System.out.println(output);
    }

    /** Start from the first rotting orange, doing BFS level order traversal, to count how many levels we
     * reached until queue is empty. We also need a counter to check if we rotted all oranges finally */
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    count++;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // corner case: if no oranges in the grid, return 0 directly
        if (count == 0) {
            return 0;
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                count--;
                int x = curPoint[0], y = curPoint[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = 2;
                }
                if (x < n - 1 && grid[x + 1][y] == 1) {
                    queue.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = 2;
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = 2;
                }
                if (y < m - 1 && grid[x][y + 1] == 1) {
                    queue.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = 2;
                }
            }
            level++;
        }

        // WARNING: MUST return level - 1, not level
        if (count == 0) {
            return level - 1;
        }
        return -1;
    }
}
