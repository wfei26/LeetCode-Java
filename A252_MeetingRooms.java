import java.util.Arrays;

public class A252_MeetingRooms {
    public static void main(String[] args) {
        A252_MeetingRooms solution = new A252_MeetingRooms();
        Interval[] inputs = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        boolean output = solution.canAttendMeetings(inputs);
        System.out.println(output);
    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        //REMEMBER: new comparator style in Java 8, remember it!
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
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
