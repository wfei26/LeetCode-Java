public class A124_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        A124_BinaryTreeMaximumPathSum solution = new A124_BinaryTreeMaximumPathSum();
        int[] myInputs = {-5,7,9,10,15,20};
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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxSum;
    }

    /*
    * 这题是经典的 "recursion的返回值并不是我们最后要求的值" 的题型。recursion返回的是从下至上包括当前root的单条最大路径；而我们要求
    * 的maxSum的结果是在recursion的过程中不断更新的，也就是跨过当前root包含左子树和右子树的最大路径
    *
    * Recursion rule:
    * 1. root must be used
    * 2. at most one child can be used
    * 3. maxSum does not have any relationship with recursion function, need to be calculated during every recursive call
    * */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // if left or right subtree is negative sum, we will drop the entire subtree (without adding them to sum)
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, left + root.val + right);
        return Math.max(left, right) + root.val;
    }
}
