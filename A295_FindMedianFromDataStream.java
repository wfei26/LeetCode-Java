import java.util.Collections;
import java.util.PriorityQueue;

public class A295_FindMedianFromDataStream {
    public static void main(String[] args) {
        A295_FindMedianFromDataStream solution = new A295_FindMedianFromDataStream();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }


    //left part - max heap
    PriorityQueue<Integer> maxHeap;
    //right part - min heap
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public A295_FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    /** AddNum() strategy: divides the entire “array" into two parts and saves in two priority queues max heap and min
     * heap. Every new element will be inserted into the max heap, and then (after heapify) move the root of max heap
     * to to the min heap. Always keep balance (maxHeap.size() >= minHeap.size()) of two sides after insertion step. */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        // keep size of minHeap is always smaller than or equal to max heap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double)maxHeap.peek();
        }
        else {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
