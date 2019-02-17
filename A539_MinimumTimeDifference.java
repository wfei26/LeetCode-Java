import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A539_MinimumTimeDifference {
    public static void main(String[] args) {
        A539_MinimumTimeDifference solution = new A539_MinimumTimeDifference();
        List<String> input = new ArrayList<>(Arrays.asList("23:59", "00:00"));
        int output = solution.findMinDifference(input);
        System.out.println(output);
    }

    /** convert time time format to minutes sum, sort them, and check min difference */
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (String time : timePoints) {
            String[] curTime = time.split(":");
            int hour = Integer.valueOf(curTime[0]);
            int minute = Integer.valueOf(curTime[1]);
            times.add(hour * 60 + minute);
        }

        Collections.sort(times);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < times.size(); i++) {
            minDiff = Math.min(minDiff, times.get(i) - times.get(i - 1));
        }
        // corner case: if min difference is from two days, then we need to get the rest minute of the first day
        // and starting minute of second day, and sum them up
        // eg: 23:59 and 00:00
        minDiff = Math.min(minDiff, 24 * 60 - times.get(times.size() - 1) + times.get(0));
        return minDiff;
    }
}
