import java.util.LinkedList;
import java.util.Queue;

public class A286_WallAndGates {
    public static void main(String[] args) {
        A286_WallAndGates solution = new A286_WallAndGates();
        int inf = Integer.MAX_VALUE;
        int[][] input = {{inf, -1, 0, inf}, {inf, inf, inf, -1},
                {inf, -1, inf, -1}, {0, -1, inf, inf}};
        solution.wallsAndGates(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** BFS traversal (add all starting points to queue, and operate them simultaneously) */
    final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }

        int n = rooms.length, m = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];

                for (int j = 0; j < 4; j++) {
                    int dx = x + dir[j][0];
                    int dy = y + dir[j][1];

                    if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || rooms[dx][dy] != INF) {
                        continue;
                    }
                    queue.offer(new int[]{dx, dy});
                    rooms[dx][dy] = Math.min(rooms[dx][dy], level);
                }
            }
            level++;
        }
    }
}
