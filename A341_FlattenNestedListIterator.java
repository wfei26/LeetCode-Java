import java.util.List;
import java.util.Stack;

public class A341_FlattenNestedListIterator {
    public static void main(String[] args) {
        A341_FlattenNestedListIterator solution = new A341_FlattenNestedListIterator();
    }

    /** use stack to do a pre-processing, store all elements if input from last to first. We add elements reversely is
     * because we can add more nested list into stack once we find more nested list when we deal with top elements of
     * stack */
    Stack<NestedInteger> stack = new Stack<>();
    public A341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        return stack.pop().getInteger();
    }

    /** determine whether top element of stack is a number, if so -> return true; else -> iteratively add all elements
     * into stack again */
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            NestedInteger curList = stack.pop();
            for (int i = curList.getList().size() - 1; i >= 0; i--) {
                stack.push(curList.getList().get(i));
            }
        }
        return false;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
