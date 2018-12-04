import java.util.PriorityQueue;

public class A703_KthLargestElementInAStream {
    public static void main(String[] args) {
        int[] input = {5, -1};
        A703_KthLargestElementInAStream kthLargest = new A703_KthLargestElementInAStream(3, input);
        System.out.println(kthLargest.add(2));   // returns 2
        System.out.println(kthLargest.add(1));   // returns 2
        System.out.println(kthLargest.add(-1));  // returns 2
        System.out.println(kthLargest.add(3));   // returns 2
        System.out.println(kthLargest.add(4));   // returns 3
    }

    // use a min heap to store top k largest element
    PriorityQueue<Integer> pq;
    int numK;
    public A703_KthLargestElementInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        numK = k;
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            pq.poll();
        }
    }

    public int add(int val) {
        if (pq.size() < numK) {
            pq.offer(val);
        }
        // MUST use else if at here to avoid offer two times when pq.size() < k
        else if (pq.peek() < val) {
            pq.offer(val);
            pq.poll();
        }
        return pq.peek();
    }
}
