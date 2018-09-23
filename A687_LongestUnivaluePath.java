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

        calcLength(root, root.val);
        return maxLength;
    }

    public int calcLength(TreeNode curNode, int curVal) {
        if (curNode == null) {
            return 0;
        }

        //pass current node value and child node to next recursion call
        int leftLength = calcLength(curNode.left, curNode.val);
        int rightLength = calcLength(curNode.right, curNode.val);
        //maxLength should be max sum of length of right subtree + right subtree
        maxLength = Math.max(maxLength, rightLength + leftLength);
        //if current node value on current recursion step is equal to previous node value
        //add length by 1
        if (curNode.val == curVal) {
            return Math.max(leftLength, rightLength) + 1;
        }
        return 0;
    }
}
