import java.util.ArrayList;
import java.util.List;

public class A056_MergeIntervals {
    public static void main(String[] args) {
        A056_MergeIntervals solution = new A056_MergeIntervals();
        List<Interval> oldList = solution.createList();
        System.out.println("Previous list:");
        solution.print(oldList);
        List<Interval> newList = solution.merge(oldList);
        System.out.println("New list:");
        solution.print(newList);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort((a1, a2) -> Integer.compare(a1.start, a2.start));
        List<Interval> resultList = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                Interval newInterval = new Interval(start, end);
                resultList.add(newInterval);
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
            else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        resultList.add(new Interval(start, end));
        return resultList;
    }

    public List<Interval> createList() {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        Interval d = new Interval(15, 18);
        List<Interval> newList = new ArrayList<>();
        newList.add(a);
        newList.add(b);
        newList.add(c);
        newList.add(d);
        return newList;
    }

    public void print(List<Interval> myList) {
        System.out.print("[");
        for (int i = 0; i < myList.size(); i++) {
            System.out.print("[" + myList.get(i).start + "," + myList.get(i).end +  "]");
            if (i != myList.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
 }

