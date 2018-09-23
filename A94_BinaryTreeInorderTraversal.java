import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        A94_BinaryTreeInorderTraversal solution = new A94_BinaryTreeInorderTraversal();
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
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            //Find the most left node (until its left subtree is null),
            //meanwhile, push every traversed nodes into stack
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            //Set curNode to top element in stack and put the value into result list
            curNode = stack.pop();
            results.add(curNode.val);
            //Set curNode to right subtree (to traverse left most node in right subtree in next iteration)
            curNode = curNode.right;
        }
        return results;
    }
}
