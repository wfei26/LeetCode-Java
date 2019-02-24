public class A998_MaximumBinaryTreeII {
    public static void main(String[] args) {
        A998_MaximumBinaryTreeII solution = new A998_MaximumBinaryTreeII();
        TreeNode output = solution.insertIntoMaxTree(new TreeNode(1), 2);
        System.out.println(output.val);
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        // if val is greater than root value, then the entire tree should be in the left subtree of new node
        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        // if val is not greater than root value, then it must in right subtree of current root
        // we should keep recursively finding its position
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
