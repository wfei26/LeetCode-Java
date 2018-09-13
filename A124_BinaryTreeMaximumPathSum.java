public class A124_BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        A124_BinaryTreeMaximumPathSum solution = new A124_BinaryTreeMaximumPathSum();
        int[] myInputs = {7,9,10,15,20};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.maxPathSum(myTree);
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

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, left + root.val + right);
        return Math.max(left, right) + root.val;
    }
}
