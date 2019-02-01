import java.util.Arrays;

public class A435_NonOverlappingIntervals {
    public static void main(String[] args) {
        A435_NonOverlappingIntervals solution = new A435_NonOverlappingIntervals();
        Interval[] intervals = {new Interval(1,100), new Interval(11,22), new Interval(1,11), new Interval(2,12)};
        int output = solution.eraseOverlapIntervals(intervals);
        System.out.println(output);
    }

    // core thinking: least is the most
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // sort intervals by ending time
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));

        // use greedy algorithm to find the max number of non-overlapping intervals
        int count = 1;
        int curEndIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[curEndIndex].end) {
                count++;
                curEndIndex = i;
            }
        }
        // the rest will be min number need to remove
        return intervals.length - count;
    }

    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0; end = 0;
        }
        Interval(int s, int e) {
            start = s; end = e;
        }
    }
}
