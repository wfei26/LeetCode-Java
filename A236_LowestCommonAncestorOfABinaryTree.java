public class A236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        A236_LowestCommonAncestorOfABinaryTree solution = new A236_LowestCommonAncestorOfABinaryTree();
        TreeNode myTree = new TreeNode(5);
        myTree.left = new TreeNode(6);
        myTree.right = new TreeNode(10);
        myTree.left.left = new TreeNode(7);
        myTree.left.right = new TreeNode(8);
        TreeNode output = solution.lowestCommonAncestor(myTree, myTree.left, myTree.left.right);
        System.out.println(output.val);
    }

    /** Key point: once we find one of the node in one side, but the other side return null, then we DO NOT need to find
     * the other node, because current return node must be the ancestor of the other node. (Assume the input is always
     * valid). But if two nodes are in both side, then we can return current root as their LCA */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p|| root == q) {
            return root;
        }

        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        //if left subtree is null, then right subtree will be the ancestor itself, as well as null on the left
        //if right subtree is null, then left subtree will be the ancestor itself, as well as null on the right
        //if left subtree and right subtree are not null, then least recent recursive root will be their LCA
        if (leftSubtree == null) {
            return rightSubtree;
        }
        else if (rightSubtree == null) {
            return leftSubtree;
        }
        else {
            return root;
        }
    }
}
