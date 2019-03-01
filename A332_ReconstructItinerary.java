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

    /**
     * Step 1: build a graph -> key: departure, value: all possible arrivals in a PriorityQueue
     * Step 2: use dfs recursively add destination into result list
     *
     * Try this example: [["JFK","ATL"],["JFK","LAX"],["JFK","ORD"],["LAX","PVG"],["ORD","PEK"],["PVG","JFK"],["PEK","JFK"]]
     * */
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // build graph
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs(map, itinerary, "JFK");
        return itinerary;
    }

    /** if current departure has next destinations, we need to traverse all possible paths. Otherwise, add it into result */
    public void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> itinerary, String departure) {
        // final destination
        if (map.get(departure) == null) {
            itinerary.add(departure);
            return;
        }

        // traverse all possible path, if current departure does not have any destinations, it will not enter the loop,
        // and add current airport to the front of result list directly
        PriorityQueue<String> arrivals = map.get(departure);
        while (!arrivals.isEmpty()) {
            dfs(map, itinerary, arrivals.poll());
        }
        // use addFirst() because of the order of recursion stack
        itinerary.addFirst(departure);
    }
}
