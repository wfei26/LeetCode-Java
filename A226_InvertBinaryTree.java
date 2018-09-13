public class A226_InvertBinaryTree {
    public static void main (String[] args) {
        A226_InvertBinaryTree solution = new A226_InvertBinaryTree();
        int[] myInputs = {1,2,3,4,5,6,7,8,9};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        TreeNode newTree = solution.invertTree(myTree);
        solution.printTree(newTree);
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

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
