public class A951_FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
        A951_FlipEquivalentBinaryTrees solution = new A951_FlipEquivalentBinaryTrees();
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(2);

        boolean output = solution.flipEquiv(tree1, tree2);
        System.out.println(output);
    }

    /** use bottom-up to recursively check left subtree and right subtree */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        // if one of them is null, the other one is not null, return false
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // check whether two trees have same two children nodes or has flipped children nodes
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
