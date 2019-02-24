import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A339_NestedListWeightSum {
    public static void main(String[] args) {
        A339_NestedListWeightSum solution = new A339_NestedListWeightSum();
    }

    /** use BFS level order traversal:
     * if polled item is an integer, multiply level value and add to result
     * if polled item is a list, add all items to queue */
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int result = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    result += ni.getInteger() * level;
                }
                else {
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return result;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        public boolean isInteger();

        public int getInteger();

        public List<NestedInteger> getList();
    }
}

