import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class A636_ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        A636_ExclusiveTimeOfFunctions solution = new A636_ExclusiveTimeOfFunctions();
        List<String> input = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        int[] output = solution.exclusiveTime(2, input);
        for (int time : output) {
            System.out.println(time);
        }
    }

    /*
    * * The sample input is very confusing when time t has mixed meaning of beginning of time t for start
    * and end of time t for end
    *
    * logs =
    * ["0:start:0",
    * "1:start:2",
    * "1:end:5",
    * "0:end:6"]
    *
    * We can increase all end time by 1 to normalize the meaning of time t, so time talways
    * means "beginning of time t"
    logs =
    * ["0:start:0",
    * "1:start:2",
    * "1:end:6",
    * "0:end:7"]
    * */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results = new int[n];
        if (logs == null || logs.size() == 0) {
            return results;
        }

        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] logSegments = log.split(":");
            // get top element from stack, and accumulate its running time by using current timestamp
            // subtract its prevTime
            if (!stack.isEmpty()) {
                results[stack.peek()] += Integer.parseInt(logSegments[2]) - prevTime;
            }
            prevTime = Integer.parseInt(logSegments[2]);

            // if current time is starting time, push into stack as "new task"
            if (logSegments[1].equals("start")) {
                stack.push(Integer.parseInt(logSegments[0]));
            }
            // if current time is ending time, pop top element to execute next task blow the top item
            // also, add time by 1
            else {
                results[stack.pop()]++;
                prevTime++;
            }
        }
        return results;
    }
}
