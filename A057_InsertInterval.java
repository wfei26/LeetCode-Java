import java.util.ArrayList;
import java.util.List;

public class A057_InsertInterval {
    public static void main(String[] args) {
        A057_InsertInterval solution = new A057_InsertInterval();
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        int n = intervals.size();
        int i = 0;

        // add every interval that have early starting time and does not have conflict with new interval to result list
        while (i < n && intervals.get(i).end < newStart) {
            result.add(intervals.get(i));
            i++;
        }

        // merge all intervals that have conflict with new interval and add final interval to result list
        while (i < n && intervals.get(i).start <= newEnd) {
            newStart = Math.min(newStart, intervals.get(i).start);
            newEnd = Math.max(newEnd, intervals.get(i).end);
            i++;
        }
        result.add(new Interval(newStart, newEnd));

        // add the rest of interval into result list
        while (i < n) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    class Interval {
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
