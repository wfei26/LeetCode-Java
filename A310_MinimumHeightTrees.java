import java.util.*;

public class A310_MinimumHeightTrees {
    public static void main(String[] args) {
        A310_MinimumHeightTrees solution = new A310_MinimumHeightTrees();
        int[][] input = {{0,3}, {1,3}, {2,3}, {4,3}, {5,4}};
        List<Integer> output = solution.findMinHeightTrees(1, input);
        for (int node : output) {
            System.out.println(node);
        }
    }

    /** The main idea is to find all nodes in the center of graph. We can do BFS topological sort from the most
     * outside of graph to the most inside of graph, until there are only one or two nodes left. Every iteration
     * we only poll out all nodes with indegree == 1 from the queue, and REMOVE the entire circle of nodes in
     * order to expose another circle of nodes inside of the current circle of nodes (REMOVE current nodes will
     * also change indegree of next level's nodes to 1) */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return new ArrayList<>();
        }

        // corner case: when input graph only has one node, it is impossible to add it into queue, since
        // its indegree is 0, we should return it directly
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(0));
        }

        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // create indegree map
        Map<Integer, Integer> indegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int node : graph.keySet()) {
            indegree.put(node, graph.get(node).size());
            if (indegree.get(node) == 1) {
                queue.offer(node);
            }
        }

        // similar to BFS topological sort
        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                for (int node : graph.get(curNode)) {
                    indegree.put(node, indegree.get(node) - 1);
                    // for all nodes exposed in outside circle, add into queue for next iteration
                    if (indegree.get(node) == 1) {
                        queue.offer(node);
                    }
                }
            }
            n -= size;
        }

        // all nodes left in queue will be all highest levels located in the center of graph
        List<Integer> result = new ArrayList<>();
        result.addAll(queue);
        return result;
    }
}
