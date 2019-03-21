import java.util.*;

public class A863_AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        A863_AllNodesDistanceKInBinaryTree solution = new A863_AllNodesDistanceKInBinaryTree();
    }

    /**
     * Step 1: use DFS to build graph with adjacency list
     * Step 2: use BFS to traverse graph until find all nodes on K level
     * */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Map<TreeNode, Set<TreeNode>> graph = new HashMap<>();
        buildGraph(graph, root);
        bfs(result, graph, target, K);
        return result;
    }

    // step 1
    public void buildGraph(Map<TreeNode, Set<TreeNode>> map, TreeNode curNode) {
        if (curNode == null) {
            return;
        }

        map.putIfAbsent(curNode, new HashSet<>());
        if (curNode.left != null) {
            map.putIfAbsent(curNode.left, new HashSet<>());
            map.get(curNode).add(curNode.left);
            map.get(curNode.left).add(curNode);
            buildGraph(map, curNode.left);
        }

        if (curNode.right != null) {
            map.putIfAbsent(curNode.right, new HashSet<>());
            map.get(curNode).add(curNode.right);
            map.get(curNode.right).add(curNode);
            buildGraph(map, curNode.right);
        }
    }

    // step 2
    public void bfs(List<Integer> result, Map<TreeNode, Set<TreeNode>> map, TreeNode start, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(start);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (k == 0) {
                    result.add(curNode.val);
                }
                for (TreeNode neighbor : map.get(curNode)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            if (k == 0) {
                break;
            }
            k--;
        }
    }
}
