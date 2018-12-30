public class A700_SearchInABinarySearchTree {
    public static void main(String[] args) {
        A700_SearchInABinarySearchTree solution = new A700_SearchInABinarySearchTree();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(7);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);

        TreeNode res = solution.searchBST(tree, 2);
        System.out.println(res.val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.val == val) {
                return curNode;
            }
            else if (curNode.val > val) {
                curNode = curNode.left;
            }
            else {
                curNode = curNode.right;
            }
        }
        return null;
    }
}
