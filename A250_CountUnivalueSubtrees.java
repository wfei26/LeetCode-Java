public class A250_CountUnivalueSubtrees {
    public static void main(String[] args) {
        A250_CountUnivalueSubtrees solution = new A250_CountUnivalueSubtrees();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(5);

        int output = solution.countUnivalSubtrees(tree);
        System.out.println(output);
    }

    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return count;
        }
        checkUnivalueTree(root);
        return count;
    }

    // it is a bottom-up recursion logic, determine from the leaf node, and build the subtree from bottom to top
    public boolean checkUnivalueTree(TreeNode curNode) {
        // recursion exit: all leaf nodes valid univalue subtrees
        if (curNode == null) {
            return true;
        }

        // use divide and conquer to recursively determine the boolean result of left subtree or right subtree
        boolean left = checkUnivalueTree(curNode.left);
        boolean right = checkUnivalueTree(curNode.right);

        // if both of left and right subtree are valid
        if (left && right) {
            // if left node or right node is not same as current node, then current subtree is not valid
            if (curNode.left != null && curNode.left.val != curNode.val) {
                return false;
            }
            if (curNode.right != null && curNode.right.val != curNode.val) {
                return false;
            }
            // if both of left node and right node are same as current node, we got a valid subtree
            // since we already checked the entire left and right subtree are valid
            count++;
            return true;
        }
        return false;
    }
}
