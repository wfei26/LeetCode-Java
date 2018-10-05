import java.util.Arrays;
import java.util.PriorityQueue;

public class A253_MeetingRoomsII {
    public static void main(String[] args) {
        A253_MeetingRoomsII solution = new A253_MeetingRoomsII();
        Interval[] inputs = {new Interval(7, 10), new Interval(2, 4)};
        int output = solution.minMeetingRooms(inputs);
        System.out.println(output);
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        //sort intervals by starting time
        Arrays.sort(intervals, (x, y) -> (x.start - y.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0].end);
        for (int i = 1; i < n; i++) {
            //*if there does not exist conflicts between previous ending time and current starting time
            //pop the top element from min heap, in order to arrange another interval into this room
            //then add new interval to PQ
            //*if there exists conflicts, add interval to PQ directly
            if (intervals[i].start >= minHeap.peek()) {
               minHeap.poll();
            }
            minHeap.offer(intervals[i].end);
        }
        return minHeap.size();
    }
}
