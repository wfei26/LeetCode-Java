public class A236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        A236_LowestCommonAncestorOfABinaryTree solution = new A236_LowestCommonAncestorOfABinaryTree();
        TreeNode myTree = new TreeNode(5);
        myTree.left = new TreeNode(6);
        myTree.right = new TreeNode(10);
        myTree.left.right = new TreeNode(7);
        myTree.left.right.left = new TreeNode(8);
        TreeNode output = solution.lowestCommonAncestor(myTree, myTree.left, myTree.left.right.left);
        System.out.println(output.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p|| root == q) {
            return root;
        }

        //recursively get left subtree and right subtree, and then return the result
        //if left subtree is null, then right subtree will be the ancestor itself, as well as null on the left
        //if right subtree is null, then left subtree will be the ancestor itself, as well as null on the right
        //if left subtree and right subtree are not null, then least recent recursive root will be their LCA
        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        // if left subtree does not contain one of the input node, then the input node must in right subtree
        // we will return the right subtree, which is the node has higher level
        if (leftSubtree == null) {
            return rightSubtree;
        }
        else if (rightSubtree == null) {
            return leftSubtree;
        }
        // if two nodes are in both side, we will return the root
        else {
            return root;
        }
    }
}
