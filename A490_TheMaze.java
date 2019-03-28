import java.util.LinkedList;
import java.util.Queue;

public class A490_TheMaze {
    public static void main(String[] args) {
        A490_TheMaze solution = new A490_TheMaze();
    }

    /** use BFS to find the best path, but there is an important thing we need to point out: we have to find next
     * obstacle in every bfs iteration. Otherwise, ball should continue to move */
    final int[][] dir=new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n=maze.length;
        int m=maze[0].length;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        boolean[][] visited=new boolean[n][m];
        visited[start[0]][start[1]]=true;

        Queue<Point> queue=new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            for (int i = 0;i < 4; i++) {
                int nextX = curPoint.x;
                int nextY = curPoint.y;

                // key point: if the ball can continue, go ahead to find the first obstacle
                while (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && maze[nextX][nextY] == 0) {
                    nextX += dir[i][0];
                    nextY += dir[i][1];
                }

                // WARNING: DO NOT FORGET to back to previous status, since current status is already out of bound
                nextX -= dir[i][0];
                nextY -= dir[i][1];

                if (visited[nextX][nextY]) {
                    continue;
                }
                if (nextX == destination[0] && nextY == destination[1]) {
                    return true;
                }

                visited[nextX][nextY] = true;
                queue.offer(new Point(nextX, nextY));
            }
        }
        return false;
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
