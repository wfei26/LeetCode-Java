import java.util.Iterator;

public class A284_PeekingIterator {
    public static void main(String[] args) {
        A284_PeekingIterator solution = new A284_PeekingIterator();
    }

    // use next to cache (peek) next element in iterator if iter has next element
    private Integer next = null;
    private Iterator<Integer> iter;

    public A284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext())
            next = iter.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    public boolean hasNext() {
        return next != null;
    }
}
