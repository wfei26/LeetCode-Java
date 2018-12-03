import java.util.*;

public class test {
    public static void main(String[] args) {
        String[] arr = {"b", "a", "c"};
        List<Integer> list = new ArrayList<>(Arrays.asList(5,2,12,1,8,3,15,7,2));
        Arrays.sort(arr, (a, b) -> (b.compareTo(a)));
        Collections.sort(list, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue(1000, Collections.reverseOrder());
    }
}
