import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class A373_FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        A373_FindKPairsWithSmallestSums solution = new A373_FindKPairsWithSmallestSums();
        int[] input1 = {1,7,11};
        int[] input2 = {2,4,6};
        List<int[]> output = solution.kSmallestPairs(input1, input2, 3);
        for (int[] pair : output) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] + b[1] - (a[0] + a[1]))
        );
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new int[]{nums1[i], nums2[j]});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        List<int[]> results = new ArrayList<>();
        while (!pq.isEmpty()) {
            results.add(pq.poll());
        }
        return results;
    }
}
