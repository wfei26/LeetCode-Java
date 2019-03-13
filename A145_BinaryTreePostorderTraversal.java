import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class A145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        A145_BinaryTreePostorderTraversal solution = new A145_BinaryTreePostorderTraversal();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<Integer> myResult = solution.postorderTraversal(myTree);
        for (int i = 0; i < myResult.size(); i++) {
            System.out.println(myResult.get(i));
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

    /** postorder is the reverse version of reversed preorder
     * first reverse means we need to add every new number into the head of result linked list
     * second reverse means we should change the order of traversal for "preorder" to right -> root -> left*/
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        while (curNode != null || !stack.isEmpty()) {
            // right
            while (curNode != null) {
                // reverse
                result.addFirst(curNode.val);
                stack.push(curNode);
                curNode = curNode.right;
            }
            // root
            curNode = stack.pop();
            // left
            curNode = curNode.left;
        }
        return result;
    }
}
