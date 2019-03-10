import java.util.*;

public class A210_CourseScheduleII {
    public static void main(String[] args) {
        A210_CourseScheduleII solution = new A210_CourseScheduleII();
    }

    /** USe topological sort with BFS to traverse the entire graph (start from the course with 0 indegree) */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // build graph: use adjacent list to reduce BFS traversal complexity
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int cur = pre[1];
            int next = pre[0];
            indegree[next]++;
            graph.putIfAbsent(cur, new ArrayList<>());
            graph.get(cur).add(next);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            result[count++] = curCourse;
            // if graph has neighbors, reduce indegree value of all neighbors by 1
            if (graph.containsKey(curCourse)) {
                List<Integer> neighbors = graph.get(curCourse);
                for (int neighbor : neighbors) {
                    indegree[neighbor]--;
                    // if next course has 0 indegree, add it into next level
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        // final count must be same as number of course
        return count == numCourses ? result : new int[0];
    }
}
