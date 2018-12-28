public class A222_CountCompleteTreeNodes {
    public static void main(String[] args) {
        A222_CountCompleteTreeNodes solution = new A222_CountCompleteTreeNodes();
        TreeNode myTree = new TreeNode(0);
        myTree.left = new TreeNode(1);
        myTree.right = new TreeNode(2);
        myTree.left.left = new TreeNode(3);
        myTree.left.right = new TreeNode(5);
        myTree.right.left = new TreeNode(6);

        int myResult = solution.countNodes(myTree);
        System.out.println(myResult);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 0, rightHeight = 0;
        TreeNode leftSubtree = root, rightSubtree = root;

        // count level of left most node and right most node
        while (leftSubtree != null) {
            leftHeight++;
            leftSubtree = leftSubtree.left;
        }
        while (rightSubtree != null) {
            rightHeight++;
            rightSubtree = rightSubtree.right;
        }

        // check whether current tree is a full binary tree
        // if so, calculate number of nodes
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        // if not, recursively count left subtree and right subtree
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
