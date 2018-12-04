public class A671_SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        A671_SecondMinimumNodeInABinaryTree solution = new A671_SecondMinimumNodeInABinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        int output = solution.findSecondMinimumValue(root);
        System.out.println(output);
    }

    // it is actually a min heap structure
    public int findSecondMinimumValue(TreeNode root) {
        // recursion exit1: when curNode is null
        if (root == null) {
            return -1;
        }
        // recursion exit2: when curNode is left node
        // but still did not find the second smallest number,
        // which means all numbers that traversed are as same as root
        if (root.left == null && root.right == null) {
            return -1;
        }

        // recursive step: recursively find second smallest number from both of left and right subtrees
        // if one of them is equal to its parent, going deeper to find again until there is a number
        // different with its parent number
        int left  = root.left.val;
        int right = root.right.val;
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        // if both of left subtree and right subtree have second smallest number
        // return the smaller one
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        // else return the valid one
        else {
            if (left != -1) {
                return left;
            }
            else {
                return right;
            }
        }
    }
}
