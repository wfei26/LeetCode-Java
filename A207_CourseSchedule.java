import java.util.*;

public class A207_CourseSchedule {
    public static void main(String[] args) {
        A207_CourseSchedule solution = new A207_CourseSchedule();
        int[][] input = {{1, 0}, {2, 1}};
        boolean output = solution.canFinish(3, input);
        System.out.println(output);
    }

    /** USe topological sort with BFS to traverse the entire graph (start from the course with 0 indegree) */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;
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
        return count == numCourses;
    }
}
