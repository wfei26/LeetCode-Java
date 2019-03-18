import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A429_NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        A429_NAryTreeLevelOrderTraversal solution = new A429_NAryTreeLevelOrderTraversal();
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                curList.add(curNode.val);
                if (curNode.children != null) {
                    for (Node child : curNode.children) {
                        queue.add(child);
                    }
                }
            }
            result.add(curList);
        }
        return result;
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
