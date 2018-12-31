public class A530_MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        A530_MinimumAbsoluteDifferenceInBST solution = new A530_MinimumAbsoluteDifferenceInBST();
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(2);

        int output = solution.getMinimumDifference(tree);
        System.out.println(output);
    }

    int minDiff = Integer.MAX_VALUE;
    int preVal = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder(root);
        return minDiff;
    }

    // use inorder traversal to recursively find the min diff, since inorder traversal will be a sorted array
    public void inorder(TreeNode curNode) {
        if (curNode == null) {
            return;
        }
        inorder(curNode.left);
        if (preVal != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, Math.abs(preVal - curNode.val));
        }
        preVal = curNode.val;
        inorder(curNode.right);
    }
}
