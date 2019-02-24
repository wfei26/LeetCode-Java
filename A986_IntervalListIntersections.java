import java.util.ArrayList;
import java.util.List;

public class A986_IntervalListIntersections {
    public static void main(String[] args) {
        A986_IntervalListIntersections solution = new A986_IntervalListIntersections();
        Interval[] intervals1 = {new Interval(1, 3)};
        Interval[] intervals2 = {new Interval(2, 5)};
        Interval[] output = solution.intervalIntersection(intervals1, intervals2);
        System.out.println(output[0].start + " " + output[0].end);
    }

    /** Use two pointers to track interval list A and interval list B, respectively. Once there exists two overlapping
     * intervals, we add the overlapping part into result list. Then move the pointer with left most index to next interval
     * Three steps: check overlapping -> if exists, add overlapping interval to list -> then move interval pointer */
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A.length == 0 || B.length == 0) {
            return new Interval[0];
        }

        int n = A.length, m = B.length;
        List<Interval> overlapList = new ArrayList<>();
        for (int aPtr = 0, bPtr = 0; aPtr < n && bPtr < m;) {
            // no overlapping
            if (A[aPtr].start > B[bPtr].end) {
                bPtr++;
            }
            // no overlapping
            else if (B[bPtr].start > A[aPtr].end) {
                aPtr++;
            }
            // exists overlapping
            else {
                // even if two intervals only has overlapping in boundary (equal case), we still add it into result
                Interval overlapInterval = new Interval(
                        Math.max(A[aPtr].start, B[bPtr].start), Math.min(A[aPtr].end, B[bPtr].end));
                overlapList.add(overlapInterval);

                // compare the end index of two intervals, move the pointer on the left to next interval
                if (A[aPtr].end < B[bPtr].end) {
                    aPtr++;
                }
                else if (A[aPtr].end > B[bPtr].end) {
                    bPtr++;
                }
                // if two intervals have same end index, move two pointers simultaneously
                else {
                    aPtr++;
                    bPtr++;
                }
            }
        }
        return overlapList.toArray(new Interval[overlapList.size()]);
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
