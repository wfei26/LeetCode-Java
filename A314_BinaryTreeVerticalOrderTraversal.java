import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class A314_BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        A314_BinaryTreeVerticalOrderTraversal solution = new A314_BinaryTreeVerticalOrderTraversal();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> output = solution.verticalOrder(tree);
        for (List<Integer> list : output) {
            for (int node : list) {
                System.out.print(node + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        // group nodes by index
        Map<Integer, List<Integer>> indexToNodeList = new HashMap<>();
        indexToNodeList.put(0, new ArrayList<>());
        indexToNodeList.get(0).add(root.val);

        // convenient to get index by node
        Map<TreeNode, Integer> nodeToIndex = new HashMap<>();
        nodeToIndex.put(root, 0);

        // for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int minIndex = 0;
        int maxIndex = 0;
        // use level order traversal to assign indexes for all nodes
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curNode = queue.poll();
                int curIndex = nodeToIndex.get(curNode);

                // left child index = root index - 1
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    nodeToIndex.put(curNode.left, curIndex - 1);

                    indexToNodeList.putIfAbsent(curIndex - 1, new ArrayList<>());
                    indexToNodeList.get(curIndex - 1).add(curNode.left.val);

                    minIndex = Math.min(minIndex, curIndex - 1);
                }
                // right child index = root index + 1
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    nodeToIndex.put(curNode.right, curIndex + 1);

                    indexToNodeList.putIfAbsent(curIndex + 1, new ArrayList<>());
                    indexToNodeList.get(curIndex + 1).add(curNode.right.val);

                    maxIndex = Math.max(maxIndex, curIndex + 1);
                }
            }
        }

        for (int i = minIndex; i <= maxIndex; i++) {
            results.add(indexToNodeList.get(i));
        }
        return results;
    }
}
