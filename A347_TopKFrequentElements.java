import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class A347_TopKFrequentElements {
    public static void main(String[] args) {
        A347_TopKFrequentElements counter = new A347_TopKFrequentElements();
        int[] inputs = {1,1,1,2,2,3};
        List<Integer> outputs = counter.topKFrequentAdvanced(inputs, 2);
        for (int num : outputs) {
            System.out.println(num);
        }
    }

    //first solution: map + priority queue
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (nums.length == 0 || k == 0) {
            return results;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<HashMap.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> (a.getValue() - b.getValue())
        );

        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            results.add(0, heap.poll().getKey());
        }
        return results;
    }

    //second solution: map + bucket sort
    public List<Integer> topKFrequentAdvanced(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (nums.length == 0 || k == 0) {
            return results;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //REMEMBER how to initialize an array of list
        List<Integer>[] bucket = new List[nums.length + 1];

        //assign all elements with same frequency into a bucket with index of their frequency
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        //retrieve elements from buckets from larger higher to lower frequency
        for (int i = bucket.length - 1; i >= 0 && results.size() < k; i--) {
            if (bucket[i] != null) {
                //since k is always valid, so we can safely add all elements from each bucket
                results.addAll(bucket[i]);
            }
        }
        return results;
    }
}
