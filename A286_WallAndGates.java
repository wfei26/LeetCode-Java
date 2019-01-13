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

    public void wallsAndGates(int[][] rooms) {
        Queue<Coordinate> queue = new LinkedList<>();
        // push all 0-value points into queue, prepare for BFS
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        // BFS with four direction searching
        while (!queue.isEmpty()) {
            Coordinate curPoint = queue.poll();
            if (curPoint.x > 0 && rooms[curPoint.x - 1][curPoint.y] == Integer.MAX_VALUE) {
                rooms[curPoint.x - 1][curPoint.y] = rooms[curPoint.x][curPoint.y] + 1;
                queue.offer(new Coordinate(curPoint.x - 1, curPoint.y));
            }
            if (curPoint.x < rooms.length - 1 && rooms[curPoint.x + 1][curPoint.y] == Integer.MAX_VALUE) {
                rooms[curPoint.x + 1][curPoint.y] = rooms[curPoint.x][curPoint.y] + 1;
                queue.offer(new Coordinate(curPoint.x + 1, curPoint.y));
            }
            if (curPoint.y > 0 && rooms[curPoint.x][curPoint.y - 1] == Integer.MAX_VALUE) {
                rooms[curPoint.x][curPoint.y - 1] = rooms[curPoint.x][curPoint.y] + 1;
                queue.offer(new Coordinate(curPoint.x, curPoint.y - 1));
            }
            if (curPoint.y < rooms[0].length - 1 && rooms[curPoint.x][curPoint.y + 1] == Integer.MAX_VALUE) {
                rooms[curPoint.x][curPoint.y + 1] = rooms[curPoint.x][curPoint.y] + 1;
                queue.offer(new Coordinate(curPoint.x, curPoint.y + 1));
            }
        }
    }

    class Coordinate {
        private int x;
        private int y;
        public Coordinate(int a, int b) {
            x = a;
            y = b;
        }
    }
}
