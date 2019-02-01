import java.util.Stack;

public class A173_BinarySearchTreeIterator {
    public static void main (String[] args) {
        A173_BinarySearchTreeIterator solution = new A173_BinarySearchTreeIterator();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        BSTIterator bstIterator = new BSTIterator(myTree);

        while (bstIterator.hasNext()) {
            int myResult = bstIterator.next();
            System.out.println(myResult);
        }
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

    static class BSTIterator {
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushAllLeftNode(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        /*
         * condition 1: if curNode does not have right subtree, top element in stack is still the
         * next left subtree,
         * condition 2: if curNode has right subtree, then we will deal with right subtree as same as before
         * conclusion: treat the node on the top of stack as current middle node (root node of current subtree)
         * */
        public int next() {
            TreeNode curNode = stack.pop();
            pushAllLeftNode(curNode.right);
            return curNode.val;
        }

        // iteratively push all left nodes into stack until reach the leaf level
        public void pushAllLeftNode(TreeNode curNode) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
        }
    }

}

