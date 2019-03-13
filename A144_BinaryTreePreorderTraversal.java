import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        A144_BinaryTreePreorderTraversal solution = new A144_BinaryTreePreorderTraversal();
        int[] myInputs = {1,2,3,5,6,8};
        TreeNode myTree = solution.sortedArrayToBST(myInputs);
        List<Integer> myResult = solution.preorderTraversal(myTree);
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;

        while (curNode != null || !stack.isEmpty()) {
            // root
            while (curNode != null) {
                result.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            // left (the most left leaf node)
            curNode = stack.pop();
            // right
            curNode = curNode.right;
        }
        return result;
    }
}
