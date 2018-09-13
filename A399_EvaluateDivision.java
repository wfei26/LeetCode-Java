import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A399_EvaluateDivision {
    public static void main(String[] args) {
        A399_EvaluateDivision solution = new A399_EvaluateDivision();
        String[][] myEquations = {{"a", "b"}, {"b", "c"}};
        double[] myValues = {2.0, 3.0};
        String[][] myQueries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] myResults = solution.calcEquation(myEquations, myValues, myQueries);
        for (double val : myResults) {
            System.out.println(val);
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] results = new double[queries.length];
        if (equations.length == 0 || values.length == 0 || queries.length == 0) {
            return results;
        }

        //create a 2-d hash map to store the start point, end point, and value between two points
        Map<String, Map<String, Double>> map = new HashMap<>();
        //construct a graph using hash map
        for (int i = 0; i < equations.length; i++) {
            //create nodes for the graph
            //create new sub-hashmap if the map does not contain current key
            map.putIfAbsent(equations[i][0], new HashMap<>());
            map.putIfAbsent(equations[i][1], new HashMap<>());
            //create edges for the graph
            //put values between two nodes (on each edge)
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        //traverse all queries, use dfs to recursively calculate distances between every two nodes
        for (int i = 0; i < queries.length; i++) {
            results[i] = dfs(queries[i][0], queries[i][1], 1, map, new HashSet<>());
        }
        return results;
    }

    public double dfs(String start, String end, double product, Map<String, Map<String,Double>> map, Set<String> visited) {
        //if the map does not contain current node (start point) or already visited current node before
        if (!map.containsKey(start) || !visited.add(start)) {
            return -1;
        }

        //recursion exit: when reach the destination node, we found the correct path with product value
        if (start.equals(end)) {
            return product;
        }
        //get all neighbors of current start nodes (should be maps with next node with edge value)
        Map<String, Double> nextMap = map.get(start);
        //try all possible paths from current nodes to all neighbors until find the the end point of current query
        for (String nextPoint : nextMap.keySet()) {
            double result = dfs(nextPoint, end, product * nextMap.get(nextPoint), map, visited);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
