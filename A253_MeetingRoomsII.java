import java.util.Arrays;
import java.util.PriorityQueue;

public class A253_MeetingRoomsII {
    public static void main(String[] args) {
        A253_MeetingRoomsII solution = new A253_MeetingRoomsII();
        Interval[] inputs = {new Interval(7, 10), new Interval(2, 4)};
        int output = solution.minMeetingRooms(inputs);
        System.out.println(output);
    }

    /**
     * Maintain a priority queue that sort by ending time.
     * If new interval does not have conflict with earliest
     * ending time, we do not need to apply a new room (just poll previous interval from pq, and insert new task)
     * Otherwise, we need to apply a new room (only insert without polling out)
     * So the size of pq will only increase, bue never decrease. We can finally return size of pq, it represents number
     * of rooms we have applied.
     * */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> (a.start - b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return pq.size();
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
