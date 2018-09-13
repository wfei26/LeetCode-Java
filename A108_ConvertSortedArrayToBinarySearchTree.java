public class A108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        A108_ConvertSortedArrayToBinarySearchTree solution = new A108_ConvertSortedArrayToBinarySearchTree();
        int[] myInputs = {-10,-3,0,5,9};
        TreeNode myResult = solution.sortedArrayToBST(myInputs);
        solution.printTree(myResult);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeNode newTree = helper(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = helper(num, low, mid - 1);
        newNode.right = helper(num, mid + 1, high);
        return newNode;
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
}
