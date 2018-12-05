import java.util.LinkedList;
import java.util.Queue;

public class A207_CourseSchedule {
    public static void main(String[] args) {
        A207_CourseSchedule solution = new A207_CourseSchedule();
        int[][] input = {{1, 0}, {2, 1}};
        boolean output = solution.canFinish(3, input);
        System.out.println(output);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return true;
        }

        // count number of prerequisite courses for each course
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
        }

        // count number of courses which do not have any prerequisite
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (curCourse == prerequisites[i][1]) {
                    indegrees[prerequisites[i][0]]--;
                    // if a course has cleared all prerequisites, add to queue as next level course
                    // DO NOT PUT in outside of if statement, since we can only add this course in queue one time
                    if (indegrees[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        // if there exists an indegree does not equal to 0, return false
        for (int indegree : indegrees) {
            if (indegree != 0) {
                return false;
            }
        }
        return true;
    }
}
