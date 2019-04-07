import java.util.*;

public class A281_ZigzagIterator {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,3,5));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2,4,6));
        A281_ZigzagIterator solution = new A281_ZigzagIterator(l1, l2);
        while (solution.hasNext()) {
            System.out.println(solution.next());
        }
    }

    /** create two iterators for two lists, respectively. Use queue to store iterators. When calling next(), and first
     * element of queue still has next element, push into end of queue again */
    Queue<Iterator<Integer>> queue;
    public A281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1.iterator().hasNext()) {
            queue.offer(v1.iterator());
        }
        if (v2.iterator().hasNext()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> curIter = queue.poll();

        // WARNING: MUST call next() firstly, and store next value in a integer variable. Otherwise, queue will push the
        // exact same item with current iterator
        int nextVal = curIter.next();
        if (curIter.hasNext()) {
            queue.offer(curIter);
        }
        return nextVal;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

