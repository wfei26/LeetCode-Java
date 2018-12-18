import java.util.Collections;
import java.util.PriorityQueue;

public class A480_SlidingWindowMedian {
    public static void main(String[] args) {
        A480_SlidingWindowMedian solution = new A480_SlidingWindowMedian();
        int[] myInputs = {1,3,-1,-3,5,3,6,7};
        double[] myResults = solution.medianSlidingWindow(myInputs, 3);
        System.out.println(myResults);
    }

    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] results = new double[n - k + 1];
        if (nums == null || nums.length == 0) {
            return results;
        }

        return results;
    }

    public void addNum() {

    }

    public void removeNum() {

    }

    public double findMedian() {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            return 0;
        }

        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.size()) / 2;
        }
        else {
            return maxHeap.peek();
        }
    }
}
