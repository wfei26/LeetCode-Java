import java.util.LinkedList;
import java.util.Queue;

public class A993_CousinsInBinaryTree {
    public static void main(String[] args) {
        A993_CousinsInBinaryTree solution = new A993_CousinsInBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);

        boolean output = solution.isCousins(tree, 5, 6);
        System.out.println(output);
    }


    /** Use BFS level order traversal to check every level individually
     * 1. if we found curNode has two children x and y, return false directly because they share the same parent
     * 2. if we marked x exist, y exist, but did not go into previous condition, return true directly */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // WARNING: DO NOT FORGET to re-initialize boolean value at the beginning of every iteration!
            boolean xExist = false;
            boolean yExist = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.val == x) {
                    xExist = true;
                }
                if (curNode.val == y) {
                    yExist = true;
                }

                // two nodes share same parent
                if (curNode.left != null && curNode.right != null) {
                    if (curNode.left.val == x && curNode.right.val == y || curNode.left.val == y && curNode.right.val == x) {
                        return false;
                    }
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }

            // found correct answer
            if (xExist && yExist) {
                return true;
            }
        }
        return false;
    }
}
