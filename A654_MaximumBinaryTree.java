public class A654_MaximumBinaryTree {
    public static void main(String[] args) {
        A654_MaximumBinaryTree solution = new A654_MaximumBinaryTree();
        int[] input = {3,2,1,6,0,5};
        TreeNode output = solution.constructMaximumBinaryTree(input);
        System.out.println(output.val);
    }

    /** recursively find max number and assign to left and right subtree */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        // recursion exit: when left index is greater than right index
        if (left > right) {
            return null;
        }

        // WARNING: maxIndex MUST initialize to value of left index, NOT 0 !!!
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, right);
        return root;
    }
}
