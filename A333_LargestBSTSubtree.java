public class A333_LargestBSTSubtree {
    public static void main(String[] args) {
        A333_LargestBSTSubtree solution = new A333_LargestBSTSubtree();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.right = new TreeNode(2);
        tree.right.right = new TreeNode(6);
        int output = solution.largestBSTSubtree(tree);
        System.out.println(output);
    }

    int maxTree = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, null);
        return maxTree;
    }

    /** use bottom-up to recursively find max BST subtree */
    public ReturnValue dfs(TreeNode curNode, TreeNode parentNode) {
        if (curNode == null) {
            return new ReturnValue(0, parentNode.val, parentNode.val);
        }

        // calculate bottom subtree firstly, and give return value to its parent
        ReturnValue left = dfs(curNode.left, curNode);
        ReturnValue right = dfs(curNode.right, curNode);

        // if subtree is an invalid BST, drop the entire subtree
        if (left.size == -1 || right.size == -1 || left.upperBound > curNode.val || right.lowerBound < curNode.val) {
            return new ReturnValue(-1, 0,0);
        }

        // update maxSize if necessary
        int curTreeSize = left.size + 1 + right.size;
        maxTree = Math.max(maxTree, curTreeSize);

        // return information of current subtree to its parent, and then check bigger subtree include its parent
        // after backtracking
        return new ReturnValue(curTreeSize, left.lowerBound, right.upperBound);
    }

    class ReturnValue {
        int size;
        int lowerBound;
        int upperBound;

        public ReturnValue(int size, int lowerBound, int upperBound) {
            this.size = size;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }
}
