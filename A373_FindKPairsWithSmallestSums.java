import java.util.ArrayList;
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

    /**
     * Basic idea: the overall logic is pretty similar to merge K sorted list
     * the following are the k sorted list(each number in nums1[] full-mesh with the numbers in nums2[].
     *
     * (1,2) -> (1,9) -> (1,10) -> (1,15)
     * (7,2) -> (7,9) -> (7,10) -> (7,15)
     * (11,2) -> (11,9) -> (11,10) -> (11,15)
     * (16,2) -> (16,9) -> (16,10) -> (16,15)
     *
     * Remember how we do in "merge k sorted list"? We simply add the head of the list into the heap and when a
     * node is poll(), we just add the node.next.
     *
     * Use min_heap to keep track on next minimum pair sum, and we only need to maintain K possible
     * candidates in the data structure.
     * */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> results = new ArrayList<>();
        // create a min heap to save top k smallest element
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> (a.val1 + a.val2 - b.val1 - b.val2)
        );

        // corner case
        if (nums1.length == 0 || nums2.length == 0 || k ==0) {
            return results;
        }

        /* for every numbers in nums1, its best partner(yields min sum) always strats from nums2[0]
         * since arrays are all sorted; And for a specific number in nums1, its next candidate sould be
         * [this specific number] + nums2[current_associated_index + 1], unless out of boundary;)
         */
        for (int i = 0; i < k && i < nums1.length; i++) {
            Pair pair = new Pair(nums1[i], nums2[0], 0);
            pq.offer(pair);
        }

        // iteratively adding top k smallest element into result list
        while (k > 0 && !pq.isEmpty()) {
            Pair curPair = pq.poll();
            results.add(new int[]{curPair.val1, curPair.val2});
            k--;

            // check if current value is the largest (last) num in nums2
            if (curPair.indexVal2 == nums2.length - 1) {
                continue;
            }
            // keep current num1 unchanged, and try next greater element in nums2
            Pair nextPair = new Pair(curPair.val1, nums2[curPair.indexVal2 + 1], curPair.indexVal2 + 1);
            pq.offer(nextPair);
        }
        return results;
    }

    class Pair {
        int val1;
        int val2;
        //
        int indexVal2;

        public Pair(int num1, int num2, int curIndex){
            val1 = num1;
            val2 = num2;
            indexVal2 = curIndex;
        }
    }
}


