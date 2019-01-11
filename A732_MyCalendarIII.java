import java.util.TreeMap;

public class A732_MyCalendarIII {
    public static void main(String[] args) {
        A732_MyCalendarIII MyCalendarThree = new A732_MyCalendarIII();
        MyCalendarThree.book(10, 20); // returns 1
        MyCalendarThree.book(50, 60); // returns 1
        MyCalendarThree.book(10, 40); // returns 2
        MyCalendarThree.book(5, 15); // returns 3
        MyCalendarThree.book(5, 10); // returns 3
        int output = MyCalendarThree.book(25, 55); // returns 3

        System.out.println(output);
    }

    private TreeMap<Integer, Integer> treeMap;
    public A732_MyCalendarIII() {
        treeMap = new TreeMap<>();
    }

    /*
    * At each specific time point, an interval start from this point will add an interval count,
    * an interval end by this point will subtract an interval count. So we need to calculate
    * interval difference value for every occurred time point, and then iteratively add them all
    * to calculate max overlapping interval during the adding process.
    * We also need to use treemap to sort the time stamp, because we need to count overlapping
    * interval until each time point by time elapse order
    * */
    public int book(int start, int end) {
        // add 1 interval count on this starting time
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        // subtract 1 interval count on this ending time
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int maxOverlap = 0, curOverlap = 0;
        for (int val : treeMap.values()) {
            maxOverlap = Math.max(maxOverlap, curOverlap += val);
        }
        return maxOverlap;
    }
}
