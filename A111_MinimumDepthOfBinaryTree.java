import java.util.LinkedList;
import java.util.Queue;

public class A111_MinimumDepthOfBinaryTree {
    public static void main (String[] args) {
        A111_MinimumDepthOfBinaryTree solution = new A111_MinimumDepthOfBinaryTree();
        int[] myInputs = {-10,-3,0,5,9};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.minDepth(myTree);
        System.out.println(myResult);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeNode newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeNode helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    /** Solution 1: DFS
     * Key point:
     * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
     * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
     * */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        System.out.println(left + " " + right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        else {
            return Math.min(left, right) + 1;
        }
    }

    /** Solution 2: BFS level order traversal */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }
}
