import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class A818_RaceCar {
    public static void main(String[] args) {
        A818_RaceCar solution = new A818_RaceCar();
        int input = 6;
        int output = solution.racecar(input);
        System.out.println(output);
    }

    public int racecar(int target) {
        // int[]{a, b}, a represents position, b represents speed
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});

        // use visited set to prune BFS tree (Do not recalculate again if a node was visited)
        Set<String> visited = new HashSet<>();
        visited.add("pos" + 0 + "speed" + 1);

        int level = 0;
        while (!queue.isEmpty()) {
            // WARNING: must get the original count of current level, and then loop from queue size to 0
            // otherwise, it cannot jump out from loop since queue size will be dynamically changed
            for (int queueSize = queue.size(); queueSize > 0; queueSize--) {
                int[] curPos = queue.poll();

                // reach the target position
                if (curPos[0] == target) {
                    return level;
                }

                // condition 1: A
                int[] nextPos = new int[]{curPos[0] + curPos[1], curPos[1] * 2};
                String nextKey = "pos" + nextPos[0] + "speed" + nextPos[1];
                // pruning:
                // 1. check if we have already visited next position
                // 2. check if next position is greater than 0
                // 3. check if next position is less than double size of target
                if (visited.add(nextKey) && nextPos[0] > 0 && nextPos[0] < target * 2) {
                    queue.offer(nextPos);
                }

                // condition 2: R
                if (curPos[1] > 0) {
                    // turn left
                    nextPos = new int[]{curPos[0], -1};
                }
                else {
                    // turn right
                    nextPos = new int[]{curPos[0], 1};
                }
                nextKey = "pos" + nextPos[0] + "speed" + nextPos[1];
                if (visited.add(nextKey) && nextPos[0] > 0 && nextPos[0] < target * 2) {
                    queue.offer(nextPos);
                }
            }
            level++;
        }
        // cannot reach the target, return error number
        return -1;
    }
}
