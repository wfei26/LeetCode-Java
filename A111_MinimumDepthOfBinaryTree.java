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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        else {
            return Math.min(left, right) + 1;
        }
    }
}
