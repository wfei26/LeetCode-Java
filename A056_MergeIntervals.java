import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<Interval> resultList = new ArrayList<>();
        //sort intervals by starting time
        //CAUTION: it is list sorting at here, not array sorting
        intervals.sort((a, b) -> (a.start - b.start));
        int prevStart = intervals.get(0).start, prevEnd = intervals.get(0).end;

        //start from the second interval, iteratively compare whether current starting time
        //is greater than previous ending time
        //if so, add previous interval to result list
        //else, merge two intervals by selecting the first starting time and max ending time between them
        for (int i = 1; i < intervals.size(); i++) {
            //add valid interval to result list
            if (intervals.get(i).start > prevEnd) {
                resultList.add(new Interval(prevStart, prevEnd));

                //update prevStart and prevStart after adding the previous valid interval
                prevStart = intervals.get(i).start;
                prevEnd = intervals.get(i).end;
            }
            //merge two intervals
            else {
                prevEnd = Math.max(intervals.get(i).end, prevEnd);
            }
        }
        //DO NOT FORGET to add the last interval after the loop end
        resultList.add(new Interval(prevStart, prevEnd));
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
 }

