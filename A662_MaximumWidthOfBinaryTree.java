import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class A662_MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        A662_MaximumWidthOfBinaryTree solution = new A662_MaximumWidthOfBinaryTree();
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(5);
        head.right.right = new TreeNode(6);

        int output = solution.widthOfBinaryTree(head);
        System.out.println(output);
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // map stores node with its virtual index in every single level
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        int maxRes = 0;
        int leftMost = 0, rightMost = 0;
        while (!queue.isEmpty()) {
            // get number of node in current level
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curNode = queue.poll();

                // get virtual index of left most node in current level
                if (i == 0) {
                    leftMost = map.get(curNode);
                }
                // get virtual index of right most node in current level
                if (i == queueSize - 1) {
                    rightMost = map.get(curNode);
                }

                // assign virtual index for left child node and add to queue if it is not null
                if (curNode.left != null) {
                    map.put(curNode.left, map.get(curNode) * 2);
                    queue.offer(curNode.left);
                }
                // assign virtual index for right child node and add to queue if it is not null
                if (curNode.right != null) {
                    map.put(curNode.right, map.get(curNode) * 2 + 1);
                    queue.offer((curNode.right));
                }
            }
            // calculate length of current level and compare with previous max length
            maxRes = Math.max(maxRes, rightMost - leftMost + 1);
        }
        return maxRes;
    }
}
