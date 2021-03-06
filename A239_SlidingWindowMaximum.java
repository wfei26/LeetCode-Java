import javax.naming.spi.NamingManager;
import java.util.ArrayDeque;
import java.util.Deque;

public class A239_SlidingWindowMaximum {
    public static void main(String[] args) {
        A239_SlidingWindowMaximum solution = new A239_SlidingWindowMaximum();
        int[] myInputs = {2,1,3,4,6,3,8,9,10,12,56};
        int size = 4;
        int[] myResults = solution.maxSlidingWindow(myInputs, size);
        for (int i = 0; i < myResults.length; i++) {
            System.out.println(myResults[i]);
        }
    }

    /**
     * Solution 1: Deque
     *
     * Use deque to simulate a window with size k, insert every array INDEX into deque. We have two rules:
     * 1. if the difference between current index and max index in deque, poll out the index from deque since
     * current window cannot access that index
     * 2. if current element is grater than any element (the value on that index) in deque, poll out all smaller
     * index, then add current index into deque
     *
     * As a result elements in the deque are ordered in both sequence in array and their value. At each step the
     * head of the deque is the max element in [i-(k-1),i]
     *
     * eg: for the case 2,1,3,4,6,3,15,9,10,12,10
     * deque (store index):
     * 0   =>   0, 1   =>   2   =>   3   =>   4   =>   4, 5   =>   6   =>   6, 7   =>   6, 8   =>   6, 9   =>   10
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        // store index
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // q contains index... r contains content
            deque.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }

    /**
     * Solution 2: two pre-processing array: left max and right max
     *
     * For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4
     *
     * Partition the array in blocks of size w=4. The last block may have less then w.
     * 2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
     *
     * Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
     * left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
     *
     * Similarly calculate max in future by traversing from end to start.
     * right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
     *
     * Sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
     * sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
    * */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] results = new int[n - k + 1];

        // We need to calculate the local max from left to right and from right to left, respectively,
        // then find the result max array with every sliding window
        int[] leftLocalMax = new int[n];
        int[] rightLocalMax = new int[n];
        leftLocalMax[0] = nums[0];
        rightLocalMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // leftLocalMax saves right max bound of every sliding window
            if (i % k == 0) {
                // We need to re-initialize the local max at the beginning of every k elements
                // because we should take out the previous max number (the previous max number
                // cannot be counted for max comparison in the new window of length k)
                leftLocalMax[i] = nums[i];
            }
            else {
                leftLocalMax[i] = Math.max(leftLocalMax[i - 1], nums[i]);
            }

            // rightLocalMax saves left max bound of every sliding window
            int j = n - i - 1;
            if (j % k == k - 1) {
                rightLocalMax[j] = nums[j];
            }
            else {
                rightLocalMax[j] = Math.max(rightLocalMax[j + 1], nums[j]);
            }
        }


        // WE MUST have get local max in the window from both of local max and right local max
        // eg:           1 2 5 100 | 6 7 8 9
        // leftLocalMax  1 2 5 100 | 6 7 8 9
        // for the window 5, 100, 6, 7, if we only have leftLocalMax,
        // i.e.: results[i] = Math.max(leftLocalMax[i + k - 1], leftLocalMax[i]);
        // we will have result[i] = max(5, 7)
        // however, the max value of this window is actually 100
        // so we must traverse from right to left, then we will get the rightLocalMax[2] = 100
        // and then the correct result[2] should be max(100, 7) = 100
        for (int i = 0; i <= n - k; i++) {
            results[i] = Math.max(leftLocalMax[i + k - 1], rightLocalMax[i]);
        }
        return results;
    }
}
