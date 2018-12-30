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

    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        // DO NOT THINK TOO MUCH! DO NOT OVER-THINKING!
        // just compare new difference with previous difference and then traverse the tree until
        // we reach the leaf node
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            }
            if (root.val > target) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return result;
    }
}
