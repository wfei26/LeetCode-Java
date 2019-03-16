public class A270_ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        A270_ClosestBinarySearchTreeValue solution = new A270_ClosestBinarySearchTreeValue();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        int output = solution.closestValue(tree, 3.714286);
        System.out.println(output);
    }

    /** Iteratively traverse the BST, try to minimize candidate range to make every new candidate as closer as target */
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        TreeNode curNode = root;
        while (curNode != null) {
            if (Math.abs(curNode.val - target) < Math.abs(result - target)) {
                result = curNode.val;
            }

            // all numbers in right subtree will be eliminated
            if (curNode.val > target) {
                curNode = curNode.left;
            }
            // all numbers in left subtree will be eliminated
            else {
                curNode = curNode.right;
            }
        }
        return result;
    }
}
