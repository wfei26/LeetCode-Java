public class A236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        A236_LowestCommonAncestorOfABinaryTree solution = new A236_LowestCommonAncestorOfABinaryTree();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        TreeNode output = solution.lowestCommonAncestor(myTree, myTree.left, myTree.right);
        System.out.println(output.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
        }
        TreeNode newTree = helpers(nums, 0, nums.length - 1);
        return newTree;
    }

    public TreeNode helpers(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = helpers(num, low, mid - 1);
        newNode.right = helpers(num, mid + 1, high);
        return newNode;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p|| root == q) {
            return root;
        }

        //recursively get left subtree and right subtree, and then return the result
        //if left subtree is null, then right subtree will be the ancestor itself, as well as null on the left
        //if right subtree is null, then left subtree will be the ancestor itself, as well as null on the right
        //if left subtree and right subtree are not null, then least recent recursive root will be their LCA
        TreeNode leftSubtree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSubtree = lowestCommonAncestor(root.right, p, q);

        if (leftSubtree == null) {
            return rightSubtree;
        }
        else if (rightSubtree == null) {
            return leftSubtree;
        }
        else {
            return root;
        }
    }
}
