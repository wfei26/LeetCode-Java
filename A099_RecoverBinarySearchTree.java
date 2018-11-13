public class A099_RecoverBinarySearchTree {
    public static void main(String[] args) {
        A099_RecoverBinarySearchTree solution = new A099_RecoverBinarySearchTree();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        solution.recoverTree(myTree);
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

    /*
     * As we know, we can always use inorder traversal to traverse BST to find a sorted array
     * If we apply inorder traversal to this question, we can convert this problem to
     * "find the first invalid (unsorted) element and second invalid element in a sorted array"
     * So for the inorder traversal function, we can keep the first line and second line,
     * just change the middle part to find those two elements
     * */

    TreeNode firstWrongNode = null;
    TreeNode secondWrongNode = null;
    //to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversalHelper(root);
        //after find two error elements, swap them
        //DO NOT SWAP node, must swap value because we cannot change the structure of tree
        int tempNodeVal = firstWrongNode.val;
        firstWrongNode.val = secondWrongNode.val;
        secondWrongNode.val = tempNodeVal;
    }

    public void inOrderTraversalHelper(TreeNode curNode) {
        if (curNode == null) {
            return;
        }

        inOrderTraversalHelper(curNode.left);

        //If first element has not been found, assign it to prevElement
        if (firstWrongNode == null && prevNode.val >= curNode.val) {
            firstWrongNode = prevNode;
        }

        //If first element has already found, assign the second element to the curNode
        if(firstWrongNode != null && prevNode.val >= curNode.val) {
            secondWrongNode = curNode;
        }
        //set prevNode as current node
        prevNode = curNode;

        inOrderTraversalHelper(curNode.right);
    }
}
