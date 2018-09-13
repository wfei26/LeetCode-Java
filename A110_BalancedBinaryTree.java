import static java.lang.Math.abs;

public class A110_BalancedBinaryTree {
    public static void main (String[] args) {
        A110_BalancedBinaryTree solution = new A110_BalancedBinaryTree();
        int[] myInputs = {3,7,9,15,20};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        boolean myResult = solution.isBalanced(myTree);
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

    int depth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left) + 1, depth (root.right) + 1);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return (Math.abs(rightDepth - leftDepth) <= 1) && (isBalanced(root.left)) && (isBalanced(root.right));
    }
}
