import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A094_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        A094_BinaryTreeInorderTraversal solution = new A094_BinaryTreeInorderTraversal();
        int[] myInputs = {1, 2, 3, 5, 6, 8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<Integer> myResult = solution.inorderTraversal(myTree);
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        // WARNING: REMEMBER the condition of while loop!!!
        while (curNode != null || !stack.isEmpty()) {
            // left
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // root
            curNode = stack.pop();
            result.add(curNode.val);
            // right
            curNode = curNode.right;
        }
        return result;
    }
}
