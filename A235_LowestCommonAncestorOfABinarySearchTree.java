public class A235_LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        A235_LowestCommonAncestorOfABinarySearchTree solution = new A235_LowestCommonAncestorOfABinarySearchTree();
    }

    // use property of BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
