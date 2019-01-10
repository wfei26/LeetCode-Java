import java.util.LinkedList;
import java.util.Queue;

public class A513_FindBottomLeftTreeValue {
    public static void main(String[] args) {
        A513_FindBottomLeftTreeValue solution = new A513_FindBottomLeftTreeValue();
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);

        int res = solution.findBottomLeftValue(tree);
        System.out.println(res);
    }

    // use binary tree level order traversal to traverse the entire tree,
    // and save the first (leftmost) node value of each level.
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // the last updated res should be left most node of leaf level
            res = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
        }
        return res;
    }
}
