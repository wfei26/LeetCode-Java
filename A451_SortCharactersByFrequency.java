import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class A451_SortCharactersByFrequency {
    public static void main(String[] args) {
        A451_SortCharactersByFrequency solution = new A451_SortCharactersByFrequency();
        String input = "Aabbc";
        String output = solution.frequencySort(input);
        System.out.println(output);
    }

    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // REMEMBER AGAIN!!! Customized comparator in a PQ
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue())
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            // CAUTION: DO NOT USE pq.poll() at here
            for (int i = 0; i < pq.peek().getValue(); i++) {
                sb.append(pq.peek().getKey());
            }
            pq.poll();
        }
        return sb.toString();
    }
}
