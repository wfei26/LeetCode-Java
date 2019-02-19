import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A855_ExamRoom {
    public static void main(String[] args) {
        A855_ExamRoom solution = new A855_ExamRoom(10);
        solution.seat();
        solution.seat();
        solution.seat();
        solution.seat();
        solution.leave(4);
        solution.seat();
    }

    /** maintain a max heap, to store every empty intervals between students.
     * when seat, poll out max interval and seat in the middle
     * when leave, traverse all intervals to find left interval and right interval of leaving seat,
     * poll out them and merge them to a new interval, to add into room */
    int N;
    PriorityQueue<EmptyInterval> room;
    public A855_ExamRoom(int N) {
        this.N = N;
        // max heap: order by closest distance (to either side). If same, order by smaller number to greater number
        room = new PriorityQueue<>(
                (a, b) -> (a.closestDist == b.closestDist ? a.left - b.left : b.closestDist - a.closestDist)
        );
        // -1 represents there does not have any student seat in the room
        room.offer(new EmptyInterval(-1, N));
    }

    public int seat() {
        EmptyInterval maxInterval = room.poll();
        int newSeat = 0;
        // if exam room is empty
        if (maxInterval.left == -1) {
            newSeat = 0;
        }
        // if exam room only has one person sited on seat 0
        else if (maxInterval.right == N) {
            newSeat = N - 1;
        }
        // if exam room has two or more people
        else {
            // WARNING: NOT (right-left)/2 at here, since we need to get the actual position of new seat,
            // not the closest distance
            newSeat = (maxInterval.left + maxInterval.right) / 2;
        }

        // after seating in the middle of max empty interval, we have two new intervals
        room.offer(new EmptyInterval(maxInterval.left, newSeat));
        room.offer(new EmptyInterval(newSeat, maxInterval.right));
        return newSeat;
    }

    public void leave(int p) {
        List<EmptyInterval> intervals = new ArrayList<>(room);
        EmptyInterval leftInterval = null;
        EmptyInterval rightInterval = null;
        for (EmptyInterval interval : intervals) {
            if (interval.right == p) {
                leftInterval = interval;
            }
            if (interval.left == p) {
                rightInterval = interval;
            }
            // when find the input seat, we have the left interval and right interval of input seat
            if (leftInterval != null && rightInterval != null) {
                break;
            }
        }

        // remove two intervals, and insert a new combined interval with left most boundary and right most
        // boundary of two intervals
        room.remove(leftInterval);
        room.remove(rightInterval);
        // merge two intervals
        room.offer(new EmptyInterval(leftInterval.left, rightInterval.right));
    }

    class EmptyInterval {
        int left;
        int right;
        int closestDist;

        public EmptyInterval(int left, int right) {
            this.left = left;
            this.right = right;

            if (left == -1) {
                closestDist = right;
            }
            else if (right == N) {
                closestDist = N - 1 - left;
            }
            else {
                closestDist = (right - left) / 2;
            }
        }
    }
}
