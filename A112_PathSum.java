public class A112_PathSum {
    public static void main(String[] args) {
        A112_PathSum solution = new A112_PathSum();
        int[] myInputs = {7,9,10,15,20};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        boolean myResult = solution.hasPathSum(myTree, 22);
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        //recursion exit: curNode is leaf node and total sum equal to input sum
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        //either goes to left child or right child
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
