import java.util.Stack;

public class A897_IncreasingOrderSearchTree {
    public static void main(String[] args) {
        A897_IncreasingOrderSearchTree solution = new A897_IncreasingOrderSearchTree();

    }

    /** solution 1: iteration with stack */
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        TreeNode preNode = null;
        TreeNode curNode = root;

        // WARNING: MUST CHECK both of two conditions. Even though curNode is empty in same cases, stack may still have
        // nodes need to deal with
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            if (head == null) {
                head = curNode;
            }

            // DO NOT FORGET to set left child as null, since we do not want circular tree
            curNode.left = null;
            if (preNode != null) {
                preNode.right = curNode;
            }
            preNode = curNode;
            curNode = curNode.right;
        }
        return head;
    }

    /** solution 2: recursion with globe head */
    /** use classical inorder traversal, create new node with same value as every popped node, and connect to
     * previous newRoot */
    TreeNode newRoot = new TreeNode(-1);
    TreeNode dummy = newRoot;
    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return null;
        }

        increasingBST(root.left);
        newRoot.right = new TreeNode(root.val);
        newRoot = newRoot.right;
        increasingBST(root.right);
        return dummy.right;
    }
}
