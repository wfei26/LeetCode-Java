import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class A787_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        A787_CheapestFlightsWithinKStops solution = new A787_CheapestFlightsWithinKStops();
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int output = solution.findCheapestPrice(3, edges, 0, 2, 1);
        System.out.println(output);
    }

    /**
     * step 1: build graph, put start point, end point and weight (price) into graph
     * step 2: create a class with price (to current point), current city, and remainStops we can use
     * step 3: use a min heap (sorted by price) to find path with minimum weight that less than K + 1 stops by using BFS
     * */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // build graph: mapping relationship: start -> (end -> price)
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int price = flight[2];
            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(end, price);
        }

        // set an min heap, sort by price from low to high, and then use pq to do dijkstra algorithm
        PriorityQueue<Trip> pq = new PriorityQueue<>((a, b) -> (a.price - b.price));
        // initial point: no cost, K stops remaining
        // WARNING: we must put K + 1 stops at initial point, because when we stops K times, we can still
        // find the last edge that could reach to the destination
        pq.offer(new Trip(0, src, K + 1));

        // BFS + find minimum path
        while (!pq.isEmpty()) {
            Trip curTrip = pq.poll();
            if (curTrip.city == dst) {
                return curTrip.price;
            }

            // pruning: if there does not have enough stops we can use, skip all path after current trip
            if (curTrip.remainStops > 0) {
                // traverse all possible adjacent cities to expand BFS tree
                Map<Integer, Integer> adjacents = graph.getOrDefault(curTrip.city, new HashMap<>());
                for (Map.Entry<Integer, Integer> entry : adjacents.entrySet()) {
                    int nextCity = entry.getKey();
                    int nextPrice = entry.getValue();
                    // WARNING: DO NOT FORGET to accumulate current price as current total price to next city
                    pq.offer(new Trip(curTrip.price + nextPrice, nextCity, curTrip.remainStops - 1));
                }
            }
        }
        return -1;
    }

    class Trip {
        int price;
        int city;
        int remainStops;

        public Trip(int price, int city, int remainStops) {
            this.price = price;
            this.city = city;
            this.remainStops = remainStops;
        }
    }
}
