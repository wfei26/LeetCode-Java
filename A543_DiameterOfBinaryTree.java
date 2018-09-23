public class A543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        A543_DiameterOfBinaryTree solution = new A543_DiameterOfBinaryTree();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int output = solution.diameterOfBinaryTree(myTree);
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

    int maxSum = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return maxSum;
    }

    public int maxDepth(TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }

        //recursively calculate max depth of left and right subtree
        int maxLeft = maxDepth(curNode.left);
        int maxRight = maxDepth(curNode.right);
        //update global value of maxSum, should the sum of maxLeft and maxRight
        maxSum = Math.max(maxSum, maxLeft + maxRight);
        return Math.max(maxLeft, maxRight) + 1;
    }
}
