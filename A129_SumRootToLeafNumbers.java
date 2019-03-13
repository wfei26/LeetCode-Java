public class A129_SumRootToLeafNumbers {
    public static void main(String[] args) {
        A129_SumRootToLeafNumbers solution = new A129_SumRootToLeafNumbers();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int output = solution.sumNumbers(myTree);
        System.out.println(output);
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

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 0);
    }

    /** recursion exit: always return a path sum from a single path
     * function exit: always return total path sum with both of left and right paths */
    public int dfs(TreeNode curNode, int curSum) {
        if (curNode == null) {
            return 0;
        }

        // WARNING: DO NOT FORGET this recursion exit. Otherwise, we will always have zero in our result.
        if (curNode.left == null && curNode.right == null) {
            return curSum * 10 + curNode.val;
        }

        int left = dfs(curNode.left, curSum * 10 + curNode.val);
        int right = dfs(curNode.right, curSum * 10 + curNode.val);
        return left + right;
    }
}
