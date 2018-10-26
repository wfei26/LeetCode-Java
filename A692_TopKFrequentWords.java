import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class A692_TopKFrequentWords {
    public static void main(String[] args) {
        A692_TopKFrequentWords counter = new A692_TopKFrequentWords();
        String[] inputs = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> outputs = counter.topKFrequent(inputs, 2);
        for (String str : outputs) {
            System.out.println(str);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return results;
        }

        HashMap<String, Integer> map = new HashMap<>();

        //define a priority queue to store top k elements with k highest frequency
        //also, we need to have self-defined comparator if frequency is same -> arrange alphabet from larger to smaller
        //(eg: if we have to remove one of alphabets with same frequency, we remove the one with higher alphabetical,
        //so put it on the top of PQ)
        PriorityQueue<String> heap = new PriorityQueue<>(
                (a, b) -> ((map.get(a) == map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b))
        );

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //REMEMBER how to iterate map entries
        for (HashMap.Entry<String, Integer> entry: map.entrySet()) {
            if (k > 0) {
                heap.offer(entry.getKey());
                k--;
            }
            else {
                heap.offer(entry.getKey());
                heap.poll();
            }
        }

        //CAUTION: we need to reversely add queue element to list
        //since we want to higher frequency element in the front of list
        while (!heap.isEmpty()) {
            results.add(0, heap.poll());
        }
        return results;
    }
}
