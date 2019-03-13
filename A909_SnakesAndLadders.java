import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class A909_SnakesAndLadders {
    public static void main(String[] args) {
        A909_SnakesAndLadders solution = new A909_SnakesAndLadders();

    }

    /** Use BFS traversal to traverse all possible paths. We add six next positions in every BFS iteration.
     * If we see a position value that does not equal to -1, we will jump to that position directly and try this path
     * in next iteration */
    public int snakesAndLadders(int[][] board) {
        if (board.length == 0) {
            return 0;
        }

        int n = board.length;
        int moveCount = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                if (visited.contains(curPos)) {
                    continue;
                }
                visited.add(curPos);
                if (curPos == n * n) {
                    return moveCount;
                }

                for (int j = 1; j <= 6; j++) {
                    if (curPos + j <= n * n) {
                        int nextPos = curPos + j;
                        int nextVal = getVal(board, n, nextPos);

                        // WARNING: no matter what the value of nextVal will be, we should always add it into queue if
                        // it is not visited before. DO NOT add nextVal into queue, but add nextPos into queue
                        nextPos = nextVal == -1 ? nextPos : nextVal;
                        if (!visited.contains(nextPos)) {
                            queue.offer(nextPos);
                        }
                    }
                }
            }
            moveCount++;
        }
        return -1;
    }

    /** get coordinate from given position, and return value of that coordinate */
    public int getVal(int[][] board, int n, int pos) {
        // get row number
        int rowFromBottom = (pos - 1) / n;
        int row = n - 1 - rowFromBottom;

        // get col number
        int col = 0;
        // left -> right increasing order
        if (rowFromBottom % 2 == 0) {
            col = (pos - 1) % n;
        }
        // left -> right decreasing order
        else {
            col = n - 1 - (pos - 1) % n;
        }
        return board[row][col];
    }
}
