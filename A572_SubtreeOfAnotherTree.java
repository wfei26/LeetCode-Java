public class A572_SubtreeOfAnotherTree {
    public static void main(String[] args) {
        A572_SubtreeOfAnotherTree solution = new A572_SubtreeOfAnotherTree();
        TreeNode treeS = new TreeNode(3);
        treeS.left = new TreeNode(4);
        treeS.right = new TreeNode(5);
        treeS.left.left = new TreeNode(1);
        treeS.left.right = new TreeNode(2);

        TreeNode treeT = new TreeNode(4);
        treeT.left = new TreeNode(1);
        treeT.right = new TreeNode(2);

        boolean output = solution.isSubtree(treeS, treeT);
        System.out.println(output);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        // check if current subtree of s is same as t
        if (isSameTree(s, t)) {
            return true;
        }

        // recursively check left subtree or right subtree
        return (isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        // DO NOT FORGET to check value
        if (a.val == b.val) {
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }
        else {
            return false;
        }
    }
}
