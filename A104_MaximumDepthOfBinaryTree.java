public class A104_MaximumDepthOfBinaryTree {
    public static void main (String[] args) {
        A104_MaximumDepthOfBinaryTree solution = new A104_MaximumDepthOfBinaryTree();
        int[] myInputs = {-10,-3,0,5,9};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.maxDepth(myTree);
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = Math.max(maxDepth((root.left)), maxDepth(root.right)) + 1;
        return depth;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
