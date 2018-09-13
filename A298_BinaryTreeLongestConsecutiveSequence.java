public class A298_BinaryTreeLongestConsecutiveSequence {
    int maxVal = 0;
    public static void main (String[] args) {
        A298_BinaryTreeLongestConsecutiveSequence solution = new A298_BinaryTreeLongestConsecutiveSequence();
        int[] myInputs = {1,2,3,4,5,6};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.longestConsecutive(myTree);
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

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestConsecutiveHelper(root, 0, root.val);
        return maxVal;
    }

    public void longestConsecutiveHelper(TreeNode root, int curVal, int targetVal) {
        if (root == null) {
            return;
        }
        if (root.val == targetVal) {
            curVal++;
        }
        else {
            curVal = 1;
        }
        maxVal = Math.max(curVal, maxVal);
        longestConsecutiveHelper(root.left, curVal, root.val + 1);
        longestConsecutiveHelper(root.right, curVal, root.val + 1);
    }
}
