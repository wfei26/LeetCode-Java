import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A636_ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        A636_ExclusiveTimeOfFunctions solution = new A636_ExclusiveTimeOfFunctions();
        List<String> input = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        int[] output = solution.exclusiveTime(2, input);
        for (int time : output) {
            System.out.println(time);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results = new int[n];
        if (logs == null || logs.size() == 0) {
            return results;
        }


    }
}
