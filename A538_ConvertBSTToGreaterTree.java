public class A538_ConvertBSTToGreaterTree {
    public static void main(String[] args) {
        A538_ConvertBSTToGreaterTree solution = new A538_ConvertBSTToGreaterTree();

    }

    /** use modified inorder traversal to traver from right subtree to left subtree, and accumulate every node value
     * to a globe sum value */
    int curSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        root.val += curSum;
        curSum = root.val;
        convertBST(root.left);
        return root;
    }
}
