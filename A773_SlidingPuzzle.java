import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class A773_SlidingPuzzle {
    public static void main(String[] args) {
        A773_SlidingPuzzle solution = new A773_SlidingPuzzle();
    }

    /** 类似于华容道，0表示唯一的空位，我们需要通过不断地使用空位来交换与当前空位相邻的点，来达到最终状态
     * We can use BFS to build the decision tree, in every iteration, we push all adjacent points of current zero point
     * into queue. We also need to use a hash set with string type to store all paths that we already traversed before,
     * to avoid infinite loop */
    private final int[][] dirs = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public int slidingPuzzle(int[][] board) {
        String targetStr = "123450";
        String boardStr = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardStr += board[i][j];
            }
        }

        Set<String> visited = new HashSet<>();

        // queue stores all positions that point '0' can be swapped to
        Queue<String> queue = new LinkedList<>();
        queue.offer(boardStr);
        visited.add(boardStr);
        int res = 0;

        while (!queue.isEmpty()) {
            // level count, has to use size control here, otherwise not needed
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(targetStr)) {
                    return res;
                }
                int empty = cur.indexOf('0');
                // swap if possible
                for (int dir : dirs[empty]) {
                    String next = swap(cur, empty, dir);
                    if (visited.contains(next)) {
                        continue;
                    }

                    // add current status into set
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] strArr = str.toCharArray();
        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return new String(strArr);
    }
}
