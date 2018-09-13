import java.util.Collections;
import java.util.PriorityQueue;

public class A295_FindMedianFromDataStream {
    /** initialize your data structure here. */
    //left part - max heap
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
    //right part - min heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public static void main(String[] args) {
        A295_FindMedianFromDataStream solution = new A295_FindMedianFromDataStream();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
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
