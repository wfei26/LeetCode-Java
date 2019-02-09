public class A549_BinaryTreeLongestConsecutiveSequenceII {
    public static void main(String[] args) {
        A549_BinaryTreeLongestConsecutiveSequenceII solution = new A549_BinaryTreeLongestConsecutiveSequenceII();
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        int output = solution.longestConsecutive(tree);
        System.out.println(output);
    }

    int maxLen = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return maxLen;
    }

    /** maintain a globe variable to dynamically update the max result while doing recursion
     * For the recursion function, we can return a pair of values: max increasing value and max decreasing value.
     * We do not care whether max path is from left or right subtree, we only care the actual value of max increasing path and
     * actual value of max decreasing path. After getting the return value from both of left subtree and right subtree,
     * we can get maxInc and maxDec value by comparing leftInc and rightInc, as well as leftDec and rightDec. Then
     * we are ready to update globe value of max length */
    public NodeStatus dfs(TreeNode curNode) {
        if (curNode == null) {
            return new NodeStatus(0, 0);
        }

        int leftInc = 1, rightInc = 1;
        int leftDec = 1, rightDec = 1;

        // if left subtree has return value of max increasing path length and max decreasing path length
        if (curNode.left != null) {
            NodeStatus leftStatus = dfs(curNode.left);
            if (curNode.val == curNode.left.val + 1) {
                leftInc = leftStatus.inc + 1;
            }
            else if (curNode.val == curNode.left.val - 1){
                leftDec = leftStatus.dec + 1;
            }
        }

        // if right subtree has return value of max increasing path length and max decreasing path length
        if (curNode.right != null) {
            NodeStatus rightStatus = dfs(curNode.right);
            if (curNode.val == curNode.right.val + 1) {
                rightInc = rightStatus.inc + 1;
            }
            else if (curNode.val == curNode.right.val - 1){
                rightDec = rightStatus.dec + 1;
            }
        }
        // calculate max increasing value and max decreasing value for current node
        int maxInc = Math.max(leftInc, rightInc);
        int maxDec = Math.max(leftDec, rightDec);

        /**
         * max consecutive path has three major conditions:
         * 1. increasing path from only left subtree or only right subtree: maxInc
         * 2. decreasing path from only left subtree or only right subtree: maxDec
         * 3. increasing path from left and decreasing from right through root
         * OR decreasing path from right and increasing path from left through root: maxInc + maxDec - 1
         * */
        maxLen = Math.max(maxLen, Math.max(maxInc, maxDec));
        maxLen = Math.max(maxLen, maxInc + maxDec - 1);
        return new NodeStatus(maxInc, maxDec);
    }

    class NodeStatus {
        int inc;
        int dec;

        public NodeStatus(int increasing, int decreasing) {
            this.inc = increasing;
            this.dec = decreasing;
        }
    }
}
