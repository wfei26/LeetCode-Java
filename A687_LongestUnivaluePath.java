public class A687_LongestUnivaluePath {
    public static void main(String[] args) {
        A687_LongestUnivaluePath solution = new A687_LongestUnivaluePath();
        int[] myInputs = {1,2,3,3,5,5,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int output = solution.longestUnivaluePath(myTree);
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

    int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        calcLength(root);
        return maxLength;
    }

    public int calcLength(TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }

        // in order to get the max length includes curNode, we need to get the
        // max length of left subtree and max length of right subtree
        int left = calcLength(curNode.left);
        int right = calcLength(curNode.right);

        // if left child value is same as current root value, then we can connect them together and add
        // left path length by 1
        // if they are not same, we will reset left path length to 0, since we will get rid of entire left
        // subtree and re-initialize counter again from current root node
        if (curNode.left != null && curNode.val == curNode.left.val) {
            left++;
        }
        else {
            left = 0;
        }

        // similar operations
        if (curNode.right != null && curNode.val == curNode.right.val) {
            right++;
        }
        else {
            right = 0;
        }

        // update global max length with adding current root node
        maxLength = Math.max(maxLength, left + right);

        // the function will return the max path length of either left subtree or right subtree
        // but CANNOT return left + right since a path of subtree cannot change horizontal direction
        return Math.max(left, right);
    }
}
