import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A133_CloneGraph {
    public static void main(String[] args) {
        A133_CloneGraph solution = new A133_CloneGraph();
    }

    // MUST use label as key, but not the node address
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    /** function always return cloned node **/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        // base case: if we already cloned before, return the node with its neighbors directly
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        // clone a new node
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        // clone label and put into map
        map.put(clonedNode.label, clonedNode);
        // recursively clone its neighbors
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}
