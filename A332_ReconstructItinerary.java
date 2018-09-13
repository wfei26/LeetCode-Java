import java.util.*;

public class A332_ReconstructItinerary {
    public static void main(String[] args) {
        A332_ReconstructItinerary solution = new A332_ReconstructItinerary();
        String[][] myInputs = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<String> myResults = solution.findItinerary(myInputs);
        for (int i = 0; i < myResults.size(); i++) {
            System.out.println(myResults.get(i));
        }
    }

    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        //put all elements into map, with departure as key, and related arrivals as value (priority queue)
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs(map, itinerary, "JFK");
        return itinerary;
    }

    public void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> itinerary, String departure) {
        PriorityQueue<String> arrivals = map.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(map, itinerary, arrivals.poll());
        }
        //add next poped item to the beginning of the linked list
        itinerary.addFirst(departure);
    }
}
