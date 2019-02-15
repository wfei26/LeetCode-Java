import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A559_MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        A559_MaximumDepthOfNaryTree solution = new A559_MaximumDepthOfNaryTree();
    }


    /** BFS solution */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                // DO NOT FORGET to check whether current node is null
                if (curNode != null && curNode.children != null) {
                    for (Node child : curNode.children) {
                        queue.offer(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    /** DFS solution */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth2(child));
        }
        // MUST return depth + 1
        return depth + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
