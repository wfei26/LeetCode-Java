import java.util.LinkedList;
import java.util.Queue;

public class A785_IsGraphBipartite {
    public static void main(String[] args) {
        A785_IsGraphBipartite solution = new A785_IsGraphBipartite();
        int[][] input = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        boolean output = solution.isBipartite(input);
        System.out.println(output);
    }

    // use bfs traversal to color each level, odd level and even level nodes must have different colors
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) {
            return false;
        }

        /*
        * three status:
        * 0: not visited
        * 1: colored red
        * 2: colored blue
        * */
        int[] color = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            // independent node will NOT affect the results, so we should skill it
            // we also need to ensure current node has not been visited
            if (graph[i].length != 0 && color[i] == 0) {
                color[i] = 1;
                queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int curNode = queue.poll();
                for (int nextNode : graph[curNode]) {
                    // if nextNode has been visited, we will check if next node has same color with current node
                    if (color[nextNode] != 0) {
                        if (color[nextNode] == color[curNode]) {
                            return false;
                        }
                    }
                    // if nextNode has not been visited, we will assign different color to it and add to queue
                    else {
                        if (color[curNode] == 1) {
                            color[nextNode] = 2;
                        }
                        else {
                            color[nextNode] = 1;
                        }
                        queue.offer(nextNode);
                    }
                }
            }
        }
        return true;
    }
}
