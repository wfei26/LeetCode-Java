public class A222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        A222_CountCompleteTreeNodes solution = new A222_CountCompleteTreeNodes();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        int myResult = solution.countNodes(myTree);
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

    public int countNodes(TreeNode root) {

    }
}
