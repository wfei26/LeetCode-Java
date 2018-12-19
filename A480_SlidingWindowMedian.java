import java.util.Collections;
import java.util.PriorityQueue;

public class A480_SlidingWindowMedian {
    public static void main(String[] args) {
        A480_SlidingWindowMedian solution = new A480_SlidingWindowMedian();
        int[] input = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        double[] output = solution.medianSlidingWindow(input, 2);
        for (double median : output) {
            System.out.println(median);
        }
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] results = new double[n - k + 1];

        // we need to loop one extra iteration, because when i = nums.length, we have to go through the last window
        // after adding the last element
        for (int i = 0; i <= nums.length; i++) {
            // calculate median of window firstly, and then remove the oldest num if necessary, then add new num
            if (i >= k) {
                results[i - k] = findMedian();
                removeNum(nums[i - k]);
                if (i == nums.length) {
                    break;
                }
            }
            addNum(nums[i]);
        }
        return results;
    }

    // always keep the size of maxHeap greater than or equal to min Heap
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public void removeNum(int num) {
        if (num <= findMedian()) {
            maxHeap.remove(num); // O(n)
        }
        else {
            minHeap.remove(num); // O(n)
        }
        // still keep the size of maxHeap greater than or equal to min Heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return 0;
        }

        // when size of max heap equals to size of min heap
        if (minHeap.size() == maxHeap.size()) {
            // DO NOT FORGET to convert number to double to avoid integer overflow if input value is so large
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
        }
        // when size of max heap is greater than size of min heap
        else {
            return (double)maxHeap.peek();
        }
    }
}
