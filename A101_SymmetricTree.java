public class A101_SymmetricTree {
    public static void main(String[] args) {
        A101_SymmetricTree solution = new A101_SymmetricTree();
        int[] myInputs = {1,2,2,3,4,4,5};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        boolean myResult = solution.isSymmetric(myTree);
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        // IMPORTANT recursion exit: two input must be same
        if (left.val != right.val) {
            return false;
        }

        // use recursive call to control two nodes that need to be compared in next recursion
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
