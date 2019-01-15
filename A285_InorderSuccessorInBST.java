public class A285_InorderSuccessorInBST {
    public static void main(String[] args) {
        A285_InorderSuccessorInBST solution = new A285_InorderSuccessorInBST();
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(6);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(1);

        TreeNode p = new TreeNode(4);
        TreeNode res = solution.inorderSuccessor(tree, p);
        System.out.println(res.val);
    }

    // solution 1: iteration
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curNode = root;
        TreeNode res = null;
        while (curNode != null) {
            // if p value is greater than or equal to current node, then it must be in right subtree
            if (curNode.val <= p.val) {
                curNode = curNode.right;
            }
            // if there exist another sub-root that less than current candidate, but still greater than
            // p node, we update the res to new candidate, and then search left subtree again
            // until we find the minimum number that greater than p node value, we start to search right subtree
            else {
                res = curNode;
                curNode = curNode.left;
            }
        }
        return res;
    }

    // solution 2: recursion
    public TreeNode inorderSuccessorRecursion(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        // if given node is greater than or equal to current node, then it must in right subtree
        if (root.val <= p.val) {
            return inorderSuccessorRecursion(root.right, p);
        }
        else {
            TreeNode left = inorderSuccessorRecursion(root.left, p);
            if (left != null) {
                return left;
            }
            else {
                return root;
            }
        }
    }
}
