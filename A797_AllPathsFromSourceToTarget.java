import java.util.ArrayList;
import java.util.List;

public class A797_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        A797_AllPathsFromSourceToTarget solution = new A797_AllPathsFromSourceToTarget();
        int[][] input = {{1,2}, {3}, {3}, {}};
        List<List<Integer>> output = solution.allPathsSourceTarget(input);
        for (List<Integer> list : output) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return result;
        }

        List<Integer> tempList = new ArrayList<>();
        // add origin, and dfs until to the destination
        tempList.add(0);
        dfs(result, tempList, graph, 0, graph.length);
        return result;
    }

    // standard DFS template
    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[][] graph, int curNode, int n) {
        if (curNode == n - 1) {
            // CAUTION AND WARNING: MUST ALLOCATE MEMORY TO THIS LIST !!!!!!
            result.add(new ArrayList<>(tempList));
            return;
        }

        // we could also traverse a 2d array by this way
        for (int nextNode : graph[curNode]) {
            tempList.add(nextNode);
            dfs(result, tempList, graph, nextNode, n);
            tempList.remove(tempList.size() - 1);
        }
    }
}
