import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A098_ValidateBinarySearchTree {
    public static void main (String[] args) {
        A098_ValidateBinarySearchTree solution = new A098_ValidateBinarySearchTree();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        boolean myResult = solution.isValidBST_II(myTree);
        System.out.println(myResult);
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

    //classical inorder template
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode curNode = root;
        TreeNode preNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (curNode != null || !stack.isEmpty()) {
            //find left most subtree (until to the leaf)
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            //find top element in stack
            curNode = stack.pop();
            //if prev element is greater than or equal to cur element, then the BST
            //is not valid since traverse result is unsorted
            if (preNode != null && preNode.val >= curNode.val) {
                return false;
            }
            preNode = curNode;
            //after done left subtree, find the same things in right subtree
            curNode = curNode.right;
        }
        return true;
    }

    public boolean isValidBST_II(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        //must initialize min and max value as long value, to avoid if root in test case is
        //the max integer
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode curNode, long curMin, long curMax) {
        if (curNode == null) {
            return true;
        }

        //valid BST should be in range curMax to curMin
        //the new element in left subtree should not greater than or equal to curMax
        //the new element in right subtree should not less than or equal to curMin
        if (curNode.val <= curMin || curNode.val >= curMax) {
            return false;
        }
        boolean isLeftValid = helper(curNode.left, curMin, curNode.val);
        boolean isRightValid = helper(curNode.right, curNode.val, curMax);
        return isLeftValid && isRightValid;
    }
}
